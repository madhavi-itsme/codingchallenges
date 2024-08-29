package CodingChannenges.twopointerApprocah;

import java.util.Arrays;

/*
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

Example 1:

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]
Example 2:

Input: [-3, -1, 0, 1, 2]
Output: [0, 1, 1, 4, 9]

*/
public class SquareSortedArray {
	
	public static int[] finalArray(int[] arr) {	
		
		int i=0;
		int j=arr.length-1;
		
		int[] result=new int[arr.length];
		int k=arr.length-1;
		
		while(i<=j) {
			
			  if(k==0) {
				  result[k]=(int) Math.pow(arr[i], 2); 
			  } else if(Math.abs(arr[i]) > Math.abs(arr[j])) {
					result[k]=(int) Math.pow(arr[i], 2);
					result[k-1]=(int) Math.pow(arr[j], 2);
					
				}else {
					result[k]=(int) Math.pow(arr[j], 2);
					result[k-1]=(int) Math.pow(arr[i], 2);
				}
				
				k=k-2;
				j--;
				i++;
			}
		
		return result;
	}
	
	public static int[] finalInplaceArray(int[] arr) {	
		
		for(int i=0;i<arr.length-1;i++) {
			arr[i]=(int) Math.pow(arr[i], 2);
		}
		
		int j=0;
		int k=arr.length-1;
		
		while(j<=k) {
			if(arr[j] > arr[k]) {
				swap(j,k,arr);
				k--;
			} else if(arr[j] < arr[k]){
				j++;
			} else {
				k--;
				j++;
			}
		}
		
//		9,2 --> 2,1,0,1,9 i=0 j=4
//		2,1 --> 1,1,0,2,9 i=0 j=3
//		1,0 ==> 0,1,1,2,9 i=0 j=2
		
		return arr;
	}
	
	public static void swap(int i, int j, int[] arr) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr=new int[]{-2, -1, 0, 2, 3};
		 int[] arr1=new int[]{-3, -1, 0, 1, 2};
		 SquareSortedArray mv=new SquareSortedArray();
		 System.out.println("Final Array: "+Arrays.toString( mv.finalArray(arr)));
		 System.out.println(Arrays.toString( mv.finalInplaceArray(arr1)));
	}
}
