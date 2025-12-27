package BinarySearch;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int maxLen = 0, maxCount = 0;
        int[] freq = new int[26];
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            freq[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(end) - 'A']);

            while (end - start + 1 - maxCount > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABC", 2));
        System.out.println(characterReplacement("ABC", 3));
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }


}
