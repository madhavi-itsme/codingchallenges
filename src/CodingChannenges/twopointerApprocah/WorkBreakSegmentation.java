package CodingChannenges.twopointerApprocah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkBreakSegmentation {
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		int i=0;
		int j=0;
        while(j<=s.length()) {
        	String temp=s.subSequence(i, j).toString();
        	if(wordDict.contains(temp)){
        		i=j;
        		j++;
        	} else if(!(wordDict.contains(temp)) && j < s.length()){
        		j++;
        	} else if(j == s.length() && temp.length() > 0){
        		return false;
        	}
        	
        }
		return true;
    }
	
	
	//Intuitiveway
	
	public static boolean wordBreakIntuitive(String s, List<String> wordDict) {
		int n = s.length();

        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] word=new String[] {"leet","code"};
		String[] word1=new String[] {"cats","dog","sand","and","cat"};
		String[] word2=new String[] {"apple","pen"};
		String[] word3=new String[] {"aaaa","aaa"};



		System.out.println(wordBreak("leetcode",(((ArrayList<String>) Arrays.stream(word).collect(Collectors.toList())))));
		System.out.println(wordBreak("applepenapple",(((ArrayList<String>) Arrays.stream(word2).collect(Collectors.toList())))));

		System.out.println(wordBreakIntuitive("catsandog",(((ArrayList<String>) Arrays.stream(word1).collect(Collectors.toList())))));
// wordBreak function will fail for the below scenario , to pass the below scenario we ahev to use the other way of doing
		
		System.out.println(wordBreakIntuitive("aaaaaaa",(((ArrayList<String>) Arrays.stream(word3).collect(Collectors.toList())))));

	}

}
