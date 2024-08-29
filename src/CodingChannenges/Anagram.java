package CodingChannenges;

import java.util.Arrays;

public class Anagram {
	
	  public boolean isAnagram(String s, String t) {
	        if(s.length()!=t.length())
	           return false;

	        if(s.length() == 1 && (s.charAt(0) != t.charAt(0)))
	        {
	            return false;
	        } 

	       char[] ch1=s.toCharArray();
	       char[] ch2=t.toCharArray();

	       Arrays.sort(ch1);
	       Arrays.sort(ch2);

	       for(int i=0;i<ch1.length-1;i++){
	           if(ch1[i]!= ch2[i])
	            return false;
	       }
	       return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   Anagram ana=new Anagram();
	   System.out.println(ana.isAnagram("anagram", "nagaram"));
	   System.out.println(ana.isAnagram("rat", "car"));
	   System.out.println(ana.isAnagram("a", "n"));
	   

	}

}
