package CodingChannenges.twopointerApprocah;

import java.util.Arrays;
/*
 * Given an array of sorted numbers, move all non-duplicate number instances at the beginning of the array in-place. The relative order of the elements should be kept the same and you should not use any extra space so that the solution has constant space complexity i.e., .

Move all the unique number instances at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after moving element will be [2, 3, 6, 9].

 * */
public class MoveNonDuplicatesToFront {
	public static int[] moveTheNumbers(int[] arr) {	
		int i=1;
		int j=1;		
		while(i<=arr.length-1) {
			if(arr[j-1] != arr[i]) {
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				j++;
			}
			 System.out.println(Arrays.toString(arr));

			i++;
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr=new int[]{2, 3, 3, 3, 6, 9, 9};
		 MoveNonDuplicatesToFront mv=new MoveNonDuplicatesToFront();
		
		 
		 System.out.println(Arrays.toString( mv.moveTheNumbers(arr)));

		 
	}

}
