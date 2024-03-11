package CodingChannenges.twopointerApprocah;

import java.util.Arrays;

public class MoveNonDuplicatesToFront {
	public static int[] moveTheNumbers(int[] arr) {	
		int i=1;
		int j=1;		
		while(i<=arr.length-1) {
			if(arr[j-1] != arr[i]) {
				arr[j]=arr[i];
				j++;
			}
			i++;
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr=new int[]{2, 3, 3, 3, 6, 9, 9};
		 MoveNonDuplicatesToFront mv=new MoveNonDuplicatesToFront();
		
		 
		 System.out.println(Arrays.toString( mv.moveTheNumbers(arr)));

		 
	}

}
