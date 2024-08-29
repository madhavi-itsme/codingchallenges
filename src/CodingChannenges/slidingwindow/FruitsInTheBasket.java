package CodingChannenges.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsInTheBasket {
	
	public static  int fruits (int[] arr) {
		
		int maxLength=Integer.MIN_VALUE;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int start=0;
		
		for(int end=0;end<arr.length;end++) {
			int currentCount=map.getOrDefault(arr[end], 0);
			map.put(arr[end],currentCount+1);
			
			while(map.size()> 2) {
				int frcount=map.get(arr[start]);
				
				if(frcount==1)
					map.remove(arr[start]);
				else 
					map.put(arr[start], frcount-1);
				
			  start++;	
			}
			maxLength=Math.max(maxLength, end-start+1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("maxfruits: "+fruits(new int[] {1,2,3,2,2}));
       System.out.println("maxfruits: "+fruits(new int[] {0,1,2,2}));
       System.out.println("maxfruits: "+fruits(new int[] {1,2,1}));
	}

}
