package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static int repeatingCharacterReplacement(String str,int k){
        int result =0;

        int start=0;
        int end=0;
        int maxFrequence=0;
        int maxSubString=0;
        Map<Character, Integer> map=new HashMap<Character,Integer>();
        for(end=0;end<str.length();end++){
            Character ch=str.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFrequence=Math.max(maxFrequence, map.get(ch));
            if((end-start+1 - maxFrequence) > k){
                map.put(str.charAt(start),map.get(str.charAt(start))-1);
                start++;
            }
            maxSubString=Math.max(maxSubString,end-start+1);
        }

        return maxSubString;
    }

    public static int longestRepeatingCharacterReplacement1(String str, int k) {
        // Replace this placeholder return statement with your code
        int start=0;
        int[] freq=new int[26];
        int maxFrequency=0;
        int maxSubString=0;
        Map<Character, Integer> map=new HashMap<Character,Integer>();
        for(int end=0;end<str.length();end++){
            Character ch=str.charAt(end);
            // map.put(ch,map.getOrDefault(ch,0)+1);
            freq[str.charAt(end)-'a']++;
            maxFrequency=Math.max(maxFrequency,freq[ch-'a']);
            int wlength=end-start+1;
            if(wlength - maxFrequency > k){
                // map.put(str.charAt(start),map.get(str.charAt(start))-1);
                freq[str.charAt(start)-'a']++;
                start++;
            }
            wlength=end-start+1;
            maxSubString=Math.max(maxSubString,wlength);
        }

        return maxSubString;
    }
    public static void main(String[] args)
    {
        System.out.println(repeatingCharacterReplacement("aaacbbbaabab",2));
        System.out.println(longestRepeatingCharacterReplacement1("aaacbbbaabab",2));
    }
}
