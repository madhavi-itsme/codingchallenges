package CodingChannenges.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringreplacement {

	public static int longestreplacement(String str,int k) {
		int maxLength=0;
		int start =0;
		List<Character> list=new ArrayList<Character>();
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		
		for(int end=0;end< str.length();end++) {
			int count=map.getOrDefault(str.charAt(end), 0);
			  map.put(str.charAt(end), count+1);
              			
			
		}
		
		
		return maxLength;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
