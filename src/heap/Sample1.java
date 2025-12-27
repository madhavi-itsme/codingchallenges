package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample1 {

    public static void count(List<String> list) {

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String str : list) {
            map.merge(str, 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
    public static void main(String[] args) {

        String[] str=new String[]{"good", "excellent", "good", "poor", "poor", "good", "excellent", "poor", "poor"};
        count(Arrays.asList(str));
    }
}
