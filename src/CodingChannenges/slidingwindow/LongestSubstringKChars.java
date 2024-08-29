package CodingChannenges.slidingwindow;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LongestSubstringKChars {
	
	public static int maxLengthOfString(String str, int k) {
		int start=0;int maxLength=Integer.MIN_VALUE;
		HashSet<Character> set=new LinkedHashSet<Character>();
		
		for(int end=0;end<str.length();end++) {
			set.add(str.charAt(end));
			if(set.size() > k) {
				maxLength=Math.max(maxLength, end-start);
				set.remove(str.charAt(start));
				start++;
			}
		}
		return (maxLength == Integer.MIN_VALUE) ? 0: maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("maxLength: "+ maxLengthOfString("araaci", 1));
	}

}
