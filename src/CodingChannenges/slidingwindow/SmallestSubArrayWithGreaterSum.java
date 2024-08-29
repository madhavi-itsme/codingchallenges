package CodingChannenges.slidingwindow;

public class SmallestSubArrayWithGreaterSum {

	/*
	 * 2 < S
	 * 1< S
	 * 2+1 <7
	 * 5 < 7 
	 * 2+1+5 > 7 
	 * 
	 * 
	 * 
	 * max = 3 
	 * 
	 * 2< 7
	 * 
	 * 1+5+2 >7 
	 * 
	 * max=3 
	 * 
	 * Move the sliding window 
	 * 
	 * 
	 * 
	 * move the sliding window 
	 * */
	public static int smallSubArray(int[] arr,int k) {
		int minLength=Integer.MAX_VALUE;
		int sum=0;
		int start=0;
		
				 
		for(int end=0;end<arr.length;end++) {
			sum=sum+arr[end];
			while(sum >= k ) {
				int temp=(end-start)+1;
				System.out.println("-------------------------- ");

				System.out.println("end: "+end+": start : "+start);

				System.out.println("minLength: "+minLength+": end-start+1 : "+temp);
				minLength=Math.min(minLength, (end-start)+1);
				
				sum=sum-arr[start];
				start++;
			}
		}
	 
		return (minLength == Integer.MAX_VALUE) ? 0: minLength;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      System.out.println("Max Subarray + "+smallSubArray(new int[] {2, 1, 5, 2, 3, 2},7));
		
//      System.out.println("Max Subarray + "+smallSubArray(new int[] {2, 1, 5, 2, 3, 2},3));
//	
//      System.out.println("Max Subarray + "+smallSubArray(new int[] {2, 1, 5, 2, 8},3));
//
      System.out.println("Max Subarray + "+smallSubArray(new int[] {3, 4, 1, 1, 6},0));

	}

}
