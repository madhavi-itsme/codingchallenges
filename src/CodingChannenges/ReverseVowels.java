package CodingChannenges;

public class ReverseVowels {

	 public String reverseVowels(String s) {
	        char[] srtoch=s.toCharArray();

	        int i=0;
	        int j=srtoch.length-1;
	        StringBuilder str=new StringBuilder(s);

	        while(i<=j){
	           if(isVowel(str.charAt(i)) && isVowel(str.charAt(j))) {
	              char temp=str.charAt(j);
	              char temp1=str.charAt(i);
	                      System.out.println(temp +"---"+temp1);

	                str.setCharAt(i, temp);
	                str.setCharAt(j,temp1);
	                i++;
	                j--;
	           } else if(isVowel(srtoch[i]) && !isVowel(srtoch[j])) {
	               j--;
	           } else if(!isVowel(srtoch[i]) && isVowel(srtoch[j])) {
	               i++;
	           } else {
	               i++;
	               j--;
	           }
	        }
	        System.out.println(str.toString());
	        return s.toString();
	    }

	    public static boolean isVowel(char c){
	        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
	          return true;

	       return false;   
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ReverseVowels rv=new ReverseVowels();
     
     String str=rv.reverseVowels("hello");
     String str1=rv.reverseVowels("leetcode");

	}

}
