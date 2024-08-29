package CodingChannenges.slidingwindow;

// String is palindrome or nor

/*
 *   SAS -- > 
 *   
 *  First Approach: 
 *   
 *   MADAM --> MADAM Palindrome .
 *   
 *   M , A , D, A , M -->    O(n)
 *   
 *   String[] -- 

 *   Second Appraich: 

 *   MADAM -- > i =0 , j = 4 M = M 
 *               i++ , j--
 *              i=1 j=3     A = A
 *              i=2 j=2  
 *              
 *              -- Palindraome. 
          
 * */
public class WordsConcatenation {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirstClass n=new SecondClass();
		
		n.test();
		
//		System.out.println();
//
//		String str="Madhavi";
//		
//		int length=str.length();
//		
//		if(length == 0) {
//			System.out.println("Not Palindrome");
//		} else if(length ==1){
//			System.out.println("Palindrome");
//		}
//		
//		int i=0;
//		int j=length-1;
//		
//		String result="palindrome";
//		
//		while(i<=j) {
//			if(str.charAt(i) == str.charAt(j)) {
//				i++;j--;
//			} else {
//				result="Not Palindrome";
//				break;
//		   }
//		}
//		System.out.println(result);
		
	}

}
