package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKChars {

    public static int longestRepeatingCharacterReplacement(String s, int k) {
        int stringLength = s.length();
        int lengthOfMaxSubstring = 0;
        int start = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int mostFreqChar = 0;

        for (int end = 0; end < stringLength; ++end) {
            char currentChar = s.charAt(end);
            System.out.println("start:--"+ start);

            System.out.println("end:--"+ end);


            charFreq.put(currentChar, charFreq.getOrDefault(currentChar, 0) + 1);

            mostFreqChar = Math.max(mostFreqChar, charFreq.get(currentChar));

            System.out.println("mostFreqChar:--"+ mostFreqChar);

            if (end - start + 1 - mostFreqChar > k) {
                charFreq.put(s.charAt(start), charFreq.get(s.charAt(start)) - 1);
                start += 1;

                System.out.println("start incremented:--"+ start);

            }

            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end - start + 1);
            System.out.println("lengthOfMaxSubstring:--"+ lengthOfMaxSubstring);

        }

        return lengthOfMaxSubstring;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //System.out.println("maxLength: "+ maxLengthOfString("araaci", 1));
        System.out.println("maxLength: "+ longestRepeatingCharacterReplacement("abbcdbcbb", 1));
    }
}
