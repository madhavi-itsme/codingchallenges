package CodingChannenges.twopointerApprocah;

import java.util.ArrayList;

/*
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
Explanation: There are four unique triplets whose sum is equal to zero. smallest sum.'
Example 2:

Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.

**Constraints:**

- `3 <= arr.length <= 3000`
- `-105 <= arr[i] <= 105`
*/
import java.util.Arrays;
import java.util.List;

public class TripleSumtoZero {
	
	public List<List<Integer>> sendTripleSumToZero(int[] arr){
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));

		List<List<Integer>> list=new ArrayList<List<Integer>>();
				
		for(int index=0;index<arr.length-1;index++) {
			int  targetsum=0;		
			int i=index+1;
			 int j=arr.length-1;
			
			 
			 while(i<=j) {
				 List<Integer> innerlist=new ArrayList<Integer>();
				 
				 
				 System.out.println("arr[i] * "+arr[i]+" * arr[j] * "+arr[j]);
				 
				 if(targetsum > arr[index]+arr[i]+arr[j]) {
					 i++;
				 }else if(targetsum < arr[index]+arr[i]+arr[j] ) {
					 j--;
				 } else if(arr[index]+arr[i]+arr[j] == targetsum){
					 innerlist.add(arr[index]);
					 innerlist.add(arr[i]);
					 innerlist.add(arr[j]);
					 i++;
					 j--;
				 }
				 if(innerlist.size()>0) {
					 list.add(innerlist) ;
				 }
			 }
		}
		return list;
		
	}
	
public int sendTripleSumToClosetTarget(int[] arr,int targetsum){
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));

		List<List<Integer>> list=new ArrayList<List<Integer>>();
		 int closestsum=Integer.MAX_VALUE;

		for(int index=0;index<arr.length-2;index++) 
		{
			int i=index+1;
			 int j=arr.length-1;			
			 
			 while(i<j) 
			 {				 
				 System.out.println("arr[i] *"+arr[i]+"--arr[j] * "+arr[j]);
				 
				 int sum= arr[index]+arr[i]+arr[j];
				 int diff=targetsum-sum;
				 
				 if(Math.abs(diff) < Math.abs(closestsum)) {
					 closestsum=Math.abs(diff);
				 }
				 if(diff > 0) {
					 i++;
					 
				 } else {
					 j--;
				 }
			 
		       }
            }
	return targetsum - closestsum;
	}
	
public List<List<Integer>> sendTripleSumLessThanTarget(int[] arr,int targetsum){
	
	
	System.out.println(Arrays.toString(arr));

	List<List<Integer>> list=new ArrayList<List<Integer>>();
			
	for(int index=0;index<arr.length-1;index++) {
		int i=index+1;
		 int j=arr.length-1;		 
		 while(i<=j) {
			 List<Integer> innerlist=new ArrayList<Integer>();			 
			 System.out.println("arr[i]--"+arr[i]+"--arr[j]--"+arr[j]);			 
			 if(targetsum > arr[index]+arr[i]+arr[j]) {
				 innerlist.add(arr[index]);
				 innerlist.add(arr[i]);
				 innerlist.add(arr[j]);
				 i++;
			 }else if(targetsum < arr[index]+arr[i]+arr[j] ) {
				 j--;				 
			 } else if(arr[index]+arr[i]+arr[j] == targetsum){
				 i++;
				 j--;
			 }
			 if(innerlist.size()>0) {
				 list.add(innerlist) ;
			 }
		 }
	}
	return list;
	
}

public List<List<Integer>> subArraysSumLessthanTarget(int[] arr,int targetsum){
		

	List<List<Integer>> list=new ArrayList<List<Integer>>();				 
	int count=0;

	for(int index=0;index<=arr.length-1;index++) {
		if(arr[index] < targetsum)
		{
			list.add(Arrays.asList(arr[index]));
			count++;
		}	
		int subsum=arr[index];
		for(int j=index+1;j<arr.length-1;j++) {
			 
			 if(targetsum > subsum*arr[j]) {
					list.add(Arrays.asList(arr[index],arr[j]));
					count++;
				 } else {
//					 count=0;
					 break;
				 }
			 subsum=arr[index]*arr[j];				 
		 }
	}
	System.out.println(count);

	return list;
	
}

public List<List<Integer>> subArraysSumLessthanTargetRecursive(int[] arr,int targetsum){
	

	List<List<Integer>> list=new ArrayList<List<Integer>>();
	
			
		subArraysSumLessthanTargetRecursive1(arr,arr.length-1,targetsum,list)	;		 
		 
		
	return list;
	
}

public void subArraysSumLessthanTargetRecursive1(int[] arr,int index,int targetsum,List<List<Integer>> list){
	{
		if(index == 0 ) {
			if(targetsum > arr[0]) {
				list.add(Arrays.asList(arr[0]));
			 }		
			return ;
		} 
		
		if(targetsum > arr[index]) {
			list.add(Arrays.asList(arr[index]));
		 }				 
		
	     subArraysSumLessthanTargetRecursive1(arr,index-1, targetsum,list);
	  		  
			 if(targetsum > arr[index]*arr[index-1]) {	 
				 list.add(Arrays.asList(arr[index-1],arr[index]));
			 }
	}		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[] {-3, 0, 1, 2, -1, 1, -2};
//		
//		int[] arr1=new int[] {-5, 2, -1, -2, 3};
		TripleSumtoZero ts=new TripleSumtoZero();
		List list=ts.sendTripleSumToZero(arr);
//		
		System.out.println(Arrays.toString(list.toArray()));
//		System.out.println(Arrays.toString(ts.sendTripleSumToZero(arr1).toArray()));

//		int[] arr3=new int[] {-1, 0, 2, 3};
//		int list2=ts.sendTripleSumToClosetTarget(arr3,3);
//		
//		System.out.println(ts.sendTripleSumToClosetTarget(arr3,3));
//		
//		int[] arr4=new int[] {-3, -1, 1, 2};
//		int list3=ts.sendTripleSumToClosetTarget(arr4,1);
//		
//		System.out.println(ts.sendTripleSumToClosetTarget(arr4,1));
//		System.out.println(ts.sendTripleSumToClosetTarget(new int[] {0, 0, 1, 1, 2, 6},5));
		
//		System.out.println("/* Target sum lessthanTarget */");		
//		System.out.println(Arrays.toString(ts.sendTripleSumLessThanTarget(new int[] {-1, 0, 2, 3},3).toArray()));		

//		System.out.println("/* Sub Arrays Target sum less than target */");		
//		System.out.println(Arrays.toString(ts.subArraysSumLessthanTarget(new int[] {2, 5, 3, 10},30).toArray()));		

		System.out.println(Arrays.toString(ts.subArraysSumLessthanTarget(new int[] {10,5,2,6},100).toArray()));		

		System.out.println("/* Sub Arrays Target sum less than target RTecursive */");		
		System.out.println(Arrays.toString(ts.subArraysSumLessthanTargetRecursive(new int[] {2, 5, 3, 10},30).toArray()));		

		System.out.println(Arrays.toString(ts.subArraysSumLessthanTargetRecursive(new int[] {8, 2, 6, 5},50).toArray()));		

//		System.out.println(Arrays.toString(ts.subArraysSumLessthanTargetRecursive(new int[] {10,5,2,6},100).toArray()));		

	}

}
