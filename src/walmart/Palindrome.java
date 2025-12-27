package walmart;

public class Palindrome {

    public static boolean isPalindrome(String input){

        int i=0;int j=input.length()-1;
        while(i<j){
            if(!Character.isLetter(input.charAt(i)))
            {
                while (i < j && !Character.isLetter(input.charAt(i))) {
                    i++;
                }
            }

            while (i < j && !Character.isLetter(input.charAt(j))) {
                j--;
            }

            if(input.charAt(i) != input.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
    public static void main (String args){
        String input1 = "A man, a plan, a canal: Panama";
        String input2 = "!!Hello, World!";

        System.out.println("\"" + input1 + "\" is palindrome? " + isPalindrome(input1));
        System.out.println("\"" + input2 + "\" is palindrome? " + isPalindrome(input2));

    }

}
