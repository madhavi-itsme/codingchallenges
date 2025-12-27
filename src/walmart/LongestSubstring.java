package walmart;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static int longestStringBruteForce(String str){
        int len=0;
        StringBuffer stBu=new StringBuffer();
        for(int i=0;i<str.length();i++){
            int stBuLen=stBu.toString().length();
            if(!checkIfCharAvailable(stBu.toString(),str.charAt(i))){
                stBu.append(str.charAt(i));
            } else {

                stBu.delete(0,stBuLen);
            }
            if(stBuLen> len){
                len=stBuLen;
            }
        }
        return len;
    }

    public static boolean checkIfCharAvailable(String stBu, char ch){
        char[] strArr=stBu.toCharArray();
        Set<Character> set=new HashSet<>();

        for(char cha:strArr){
            set.add(cha);
        }

        return (set.contains(ch));
    }

    public static int longestStringTwoPointer(String str){
        int len=0;
        int i=0;int j=0;

       Set<Character> set=new HashSet<>();

        while(j < str.length()){

            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j));
                len=Math.max(len,j-i+1);
                j++;
            } else {
                set.remove(str.charAt(i));
                i++;
            }

        }

        return len;
    }

    public static void main(String args[]){
//        System.out.println(LongestSubstring.longestStringBruteForce("abcabcbb"));
        System.out.println(LongestSubstring.longestStringTwoPointer("abcabcbb"));

//        System.out.println(LongestSubstring.longestStringBruteForce("bbbbbbb"));
    }
}
