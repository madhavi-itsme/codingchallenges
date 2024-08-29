package CodingChannenges.slidingwindow;

public class MaximumSubArray {
	
	public static int maxSubArray(int[] arr,int k) {
		int max=Integer.MIN_VALUE;
		int csum=0;
		for(int i=0;i<k;i++) {
			csum=csum+arr[i];
			System.out.println(csum);
		}
		 max=Math.max(Math.abs(max), Math.abs(csum));
		 
		for(int j=k;j<arr.length;j++) {
			csum=csum+arr[j]-arr[j-k];
			
			System.out.println(csum);
			max=Math.max(Math.abs(max), Math.abs(csum));

		}
	 
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Max Subarray + "+maxSubArray(new int[] {2, 1, 5, 1, 3, 2},3));
		
		System.out.println("Max Subarray + "+maxSubArray(new int[] {2, 3, 4, 1, 5},2));

		
	}

}
