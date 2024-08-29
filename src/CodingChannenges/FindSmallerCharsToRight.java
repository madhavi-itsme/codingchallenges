package CodingChannenges;

import java.util.Arrays;

public class FindSmallerCharsToRight {
	
	public static void findSmaller(int[] nums) {
		int[] result=new int[nums.length];
		
		int k=0;
		
		for(int i=0;i<nums.length;i++) {
			int count=0;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]<nums[i]) {
					count++;
				}
			}
			result[k]=count;
			k++;
		}
		
		System.out.println(Arrays.toString(result));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findSmaller(new int[] {12, 1, 2, 3, 0, 11, 4});
		findSmaller(new int[] {5, 4, 3, 2, 1});

	}

}
