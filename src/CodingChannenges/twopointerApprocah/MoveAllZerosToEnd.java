package CodingChannenges.twopointerApprocah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MoveAllZerosToEnd {

	public static ArrayList<Integer> moveZeros(ArrayList<Integer> list) {
		int j=list.size();
		int pos=0;
		
		for(int i=0;i<j;i++) {
			if(list.get(i)!=0) {
				list.set(pos, list.get(i));
				pos++;
			}
		}
		
		while(pos<j) {
			list.set(pos, 0);
			pos++;
		}
		
		System.out.println(Arrays.toString(list.toArray()));
		
		return list;
	}
	
	public static void swap(ArrayList<Integer> list, int i,int j) {
		int temp=list.get(j);
		list.set(i, temp);
		list.set(j, 0);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[] {0,1,0,3,12};
		System.out.println(moveZeros(((ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList()))));

	}

}
