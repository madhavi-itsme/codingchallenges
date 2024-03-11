package CodingChannenges.twopointerApprocah;

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
