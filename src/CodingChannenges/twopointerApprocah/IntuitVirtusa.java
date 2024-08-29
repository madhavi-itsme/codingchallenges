package CodingChannenges.twopointerApprocah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
 * max ele1= 12   map 12 --1 
 * 
 *  val=1
 *  
 *  i=1: 54     map 45 --1 
 *  
 *  i=219       map 19--1
 *  
 *  u=3  167   map 167 --1
 * 
 * i=4     40   map 40 -- 1
 * 
 * i=5     12    
 *  
 *  
 * */
public class IntuitVirtusa {
	
	public static int getMaxElement(int[] arr1,int[] arr2) {	
		int maxElement=0;	
		List<Integer> list=Arrays.stream(arr1).boxed().collect(Collectors.toList());

		List<Integer> list2=Arrays.stream(arr1).boxed().collect(Collectors.toList());
		maxElement = Stream.concat(list.stream(), list2.stream()).reduce(0, (maxelement, element) -> maxelement > element? maxelement:element);		
		return maxElement;
	}
	
	public static void getDuplicateElements(int[] arr1,int[] arr2) {	

		List<Integer> list=Arrays.stream(arr1).boxed().collect(Collectors.toList());

		List<Integer> list2=Arrays.stream(arr1).boxed().collect(Collectors.toList());
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		List<Integer> list3=Stream.concat(list.stream(), list2.stream()).toList();
		
//		Map<Integer,Integer> map = Stream.concat(list.stream(), list2.stream()).	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] ar1=new int[] {12,54,19,167,40,12};
		int[] ar2=new int[] {99,79,12,23,19};
		

      System.out.println(IntuitVirtusa.getMaxElement(ar1, ar2));
//		int maxElement1=ar1[0];
//		
//		Map<Integer, Integer> map=new HashMap<Integer,Integer>();
//		
//		
//		
//		for(int i=0;i<=ar1.length-1;i++) {
//			if(maxElement1 < ar1[i]) {
//				maxElement1=ar1[i];
//			}
//			int val=1;
//			if(map.get(ar1[i]) !=null) {
//				 val=map.get(ar1[i])+1;
//			} 
//			
//			map.put(ar1[i], val);
//
//		}
//		
//		int maxElement2=ar2[0];
//
//		for(int i=0;i<=ar2.length-1;i++) {
//			if(maxElement1 < ar2[i]) {
//				maxElement1=ar2[i];
//			}
//			
//			int val=1;
//			if(map.get(ar2[i]) !=null) {
//				 val=map.get(ar2[i])+1;
//			} 
//			
//			map.put(ar2[i], val);
//		}
//		
//		
//		// int maxElement1= arr1.stream().iterator(Comparator.comparingInt(a,b));
//		
//		System.out.println(maxElement1 > maxElement2 ? maxElement1:maxElement2);
//		
//		for(Map.Entry<Integer, Integer> obj: map.entrySet()) {
//			if(obj.getValue() > 1) {
//				System.out.println(obj.getKey() +"-----"+ obj.getValue());
//
//			}
//		}
	}

}
