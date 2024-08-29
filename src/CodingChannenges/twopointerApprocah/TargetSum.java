package CodingChannenges.twopointerApprocah;

/*
 * Given an array of numbers sorted in ascending order and a target sum, find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target. If no such pair exists return [-1, -1].

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
Example 2:

Input: [2, 5, 9, 11], target=11
Output: [0, 2]

Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11

*/
public class TargetSum {

	 public static int[] search(int[] arr, int targetSum) {
		    // TODO: Write your code here
		    int i=0;
		    int j= arr.length-1;
		    while(i<=j)
		    {

             if(arr[i]+arr[j] == targetSum) {
            	 
            	 return new int[] { i, j };
             } else  if(arr[i]+arr[j] > targetSum){
            	 j--;
             } else  if(arr[i]+arr[j] < targetSum){
            	 i++;
             } 
		    }
		    return new int[] { -1, -1 };
		  }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      TargetSum ts=new TargetSum();
      int[] arr=new int[]{1,2,3,4,6};
      
     int[] result= ts.search(arr, 6);
     int[] result1= ts.search(new int[]{2, 5, 9, 11}, 11);
     
     System.out.println("["+result[0]+","+result[1]+"]");
     System.out.println("["+result1[0]+","+result1[1]+"]");

	}

}
