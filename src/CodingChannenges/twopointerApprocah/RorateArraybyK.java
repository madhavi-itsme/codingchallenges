package CodingChannenges.twopointerApprocah;

import java.util.Arrays;

public class RorateArraybyK {
	
	 public static void rotate(int[] nums, int k) {

		         reverse(nums,0,k-1);
		         reverse(nums,k,nums.length-1);
		         reverse(nums,0,nums.length-1);
		         
		         System.out.println(Arrays.toString(nums));
		         
		    }
		    public static void reverse(int[] nums,int start, int end){
		        for(int i=start;i<end;i++){
		            int temp=nums[start];
		            nums[start]=nums[end];
		            nums[end]=temp;
		            start++;
		            end--;
		        }
		    }
		    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RorateArraybyK.rotate(new int[] {1,2,3,4,5,6,7},3);

	}

}
