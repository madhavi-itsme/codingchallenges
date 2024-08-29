package CodingChannenges;

public class Palindrome {

	public boolean isPalindrome(String s) {
        if(s.length() < 2) 
           return true;

      String str=removeSpecialCharacter(s);
      int i=0;
      int j=str.length()-1;
       while(i<=j){
           char ch=str.charAt(i);
           char ch1=str.charAt(j);
           System.out.println(ch + ""+ ch1);
           if(Character.toLowerCase(ch) == Character.toLowerCase(ch1)) {
               i++;
               j--;
           } else {
               return false;
           }
        }
     return true;
    }

    public static String removeSpecialCharacter(String s) {
        // Initialize an empty string
        String ans = "";
        for (char ch : s.toCharArray()) {
            // if the current character is an alphabet
            if (Character.isLetter(ch))
                ans += ch;
        }
        return ans;
    }
    
    public static void main(String args[]) {
    	Palindrome p=new Palindrome();
    	System.out.println(p.isPalindrome("0P"));
    	
    }

}
