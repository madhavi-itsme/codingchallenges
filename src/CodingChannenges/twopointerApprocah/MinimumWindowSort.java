package CodingChannenges.twopointerApprocah;

import java.util.Arrays;

/*
 * 1: From the beginning of the array, move to element in the array up to which the elements are sorted i.e. where array[i] is greater than array[i+1]. Set startIndex = i.
2: From the end of the array, move to the element up to which the elements are sorted in reverse order i.e. where array[j-1] is greater than array[j]. Set endIndex = j.
3: Find the minimum and maximum elements in the subarray from startIndex to endIndex.
4: Search the sorted array from 0 to startIndex to find the index at which minimum element will be in sorted array say, minIndex.
5: Search the sorted array from endIndex to end of array to find the index at which maximum element will be in sorted array say, maxIndex.
6: Resultant sub array is the subarray between minIndex to maxIndex.

 */
public class MinimumWindowSort {
	
	public static void minimumSort(int[] a) {
		
		// TODO Auto-generated method stub
		int minIndex=0;
		int MaxIndex=0;	
           for(int i=0;i<a.length-1;i++) {
        	   if(a[i] > a[i+1]) {
        		   minIndex=a[i];
        	   }
        	   break;       	  
           }           
           for(int j=a.length-1;j>=0;j--) {
        	   if(a[j-1] > a[j]) {
        		   MaxIndex=a[j-1];
        	   }
        	   break;       	  
           }           
           Arrays.sort(a);
           
           int startIndex=0;
           int endIndex=0;
           
          int i=0;
          int j= a.length-1;
          while(i<=j) {
        	  if(a[i] == minIndex)
        		  startIndex=i;
        	  
        	  if(a[j] == MaxIndex)
        		  endIndex=j;
        	  
        	  i++;
        	  j--;      		  
          }        
          System.out.println("The subarray to be sorted is ...."+(endIndex-startIndex));          
	}

	public static void main(String args) {
		MinimumWindowSort.minimumSort(new int[] {1, 2, 5, 3, 7, 10, 9, 12});         
	}

}
