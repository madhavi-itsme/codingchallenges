package CodingChannenges.Recursion;

import java.util.Arrays;

/*
 * 
 * 1
 * 1
 * [1 2] [1,2,3],[1,2,3,4],[1,2,3,4,5]
 * 2
 * [2] [2,3] [2,3,4] [2,3,4,5]
 * 3
 * [3] [3,4] [3,4,5]
 * 4
 * [4] [4,5]
 * 5
 * [5]
 * */
public class PrintSubArrays {
	
	public static void printSubArray(int[] arr) {
		
		for(int i=0;i<=arr.length-1;i++) {
			prArray(arr,i,arr.length);
		}
		

	}
	
	public static void prArray(int[] arr,int startIndex,int endIndex) {
		if(startIndex == endIndex) {
			return;
		}
		prArray(arr,startIndex,endIndex-1);
		int[] temp=new int[endIndex-startIndex];
		int j=0;
		for(int i=startIndex;i<endIndex;i++) {
			temp[j]=arr[i];
			j++;
		}		
		System.out.println(Arrays.toString(temp));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintSubArrays.printSubArray(new int[] {1,2,3,4,5});
	}

}
