package LogAnalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    // Patterns for recognizing URLs of interest
    private static final List<String> URL_PATTERNS = Arrays.asList(
            "GET /api/users/{user_id}/count_pending_messages",
            "GET /api/users/{user_id}/get_messages",
            "GET /api/users/{user_id}/get_friends_progress",
            "GET /api/users/{user_id}/get_friends_score",
            "POST /api/users/{user_id}",
            "GET /api/users/{user_id}"
    );

    // Regex to extract the important log fields
    private static final Pattern LOG_PATTERN = Pattern.compile(
            "method=(\\w+)\\s+" +
                    "path=([^\\s]+)\\s+" +
                    ".*?connect=(\\d+)ms\\s+" +
                    "service=(\\d+)ms"
    );

    // Normalize path: replace the numerical user_id with {user_id}
    private static String normalize(String method, String path) {
        // Replace any number after /api/users/
        String normalized = path.replaceAll("/api/users/\\d+", "/api/users/{user_id}");
        return method + " " + normalized;
    }

    public static List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static List<Map<String, Object>> analyze(List<String> logs) {
        // Map: API template -> list of response times
        Map<String, List<Integer>> stats = new HashMap<>();

        for (String log : logs) {
            Matcher m = LOG_PATTERN.matcher(log);
            if (!m.find()) continue; // skip malformed lines

            String method = m.group(1);
            String path = m.group(2);
            int connect = Integer.parseInt(m.group(3));
            int service = Integer.parseInt(m.group(4));
            int responseTime = connect + service;

            String key = normalize(method, path);

            // Only include URLs we care about
            if (!URL_PATTERNS.contains(key)) continue;

            stats.computeIfAbsent(key, k -> new ArrayList<>()).add(responseTime);
        }

        // Convert results to output list
        List<Map<String, Object>> output = new ArrayList<>();

        for (String key : stats.keySet()) {
            List<Integer> times = stats.get(key);
            Collections.sort(times);

            double mean = times.stream()
                    .mapToInt(i -> i)
                    .average()
                    .orElse(0.0);

            double median;
            int size = times.size();
            if (size % 2 == 1) {
                median = times.get(size / 2);
            } else {
                median = (times.get(size / 2 - 1) + times.get(size / 2)) / 2.0;
            }

            Map<String, Object> result = new HashMap<>();
            result.put("request_identifier", key);
            result.put("called", times.size());
            result.put("response_time_mean", mean);
            result.put("response_time_median", median);

            output.add(result);
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
//        List<String> logs = Arrays.asList(
//                "2014-01-09T06:16:53.916977+00:00 heroku[router]: at=info method=GET path=/api/users/1538823671/count_pending_messages host=mygame.heroku.com fwd=\"208.54.86.162\" dyno=web.11 connect=5ms service=10ms status=200 bytes=33",
//                "2014-01-09T06:18:53.014475+00:00 heroku[router]: at=info method=GET path=/api/users/78475839/count_pending_messages host=mygame.heroku.com fwd=\"208.54.86.162\" dyno=web.10 connect=5ms service=20ms status=200 bytes=33",
//                "2014-01-09T06:20:33.142889+00:00 heroku[router]: at=info method=GET path=/api/users/847383/count_pending_messages host=mygame.heroku.com fwd=\"208.54.86.162\" dyno=web.10 connect=25ms service=55ms status=200 bytes=33"
//        );

        List<String> logs =readFile("src/LogAnalyzer/logs/logs.log");
        List<Map<String, Object>> result = analyze(logs);

        System.out.println(result);
    }
}
