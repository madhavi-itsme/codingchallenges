package CodingChannenges.twopointerApprocah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeTwoSortedArrays {
	
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        if(m==0 && n==1){
        	 nums1=new int[n];
             nums1[0]=nums2[0];
        } else if (m==1 && n==0){
            nums1[0]=nums1[0];
        }
        
        int result=nums1.length-1;
        int n1=m-1; int n2=n-1;
        
        while(n1>=0 && n2>=0){
            if(nums2[n2] > nums1[n1]){
                nums1[result]=nums2[n2];
                n2--;
                result--;
            } else if(nums2[n2] < nums1[n1]){
                int temp=nums1[n1]; 
                nums1[result]= temp;
                nums1[n1]=nums2[n2];
                n2--;
                result--;
            }
        }
      return nums1;
        
    }
	
	
	  public  static List<Integer> merge_one_into_another(List<Integer> first, List<Integer> second) {
	        // Write your code here.
	        int n=first.size();
	        int i=n-1; int j=n-1;
	        int tlen=n+n-1;

	        while(tlen >= 0){
	        	if(i < 0) {
	        		break;
	        	} else if(j < 0) {
	        		second.set(tlen,first.get(i));
	        	} else if(first.get(i) <= second.get(j)){
	                second.set(tlen--, second.get(j--));
	            } else {
	                second.set(tlen--, first.get(i--));
	            }
	        }
	        return second;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1=new int[] {1,2,3,0,0,0};
		int[] num2=new int[] {4,5,6};
		int[] result=MergeTwoSortedArrays.merge(num1,3,num2,3);
		int[] result1=MergeTwoSortedArrays.merge(null,0,new int[] {1},1);
		int[] result2=MergeTwoSortedArrays.merge(new int[] {1},1,null,0);
		
		List<Integer> result3=MergeTwoSortedArrays.merge_one_into_another(Arrays.stream(num2)
			      .boxed()
			      .collect(Collectors.toList()),Arrays.stream(num1)
			      .boxed()
			      .collect(Collectors.toList()));
		
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result1));
		System.out.println(Arrays.toString(result2));
		System.out.println("---------------------------");

		System.out.println((Arrays.toString(result3.toArray() )));
	}

}
