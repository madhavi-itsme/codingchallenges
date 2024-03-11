package CodingChannenges.twopointerApprocah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SegragateEvensAndOdds {

	 public static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {
	        // Write your code here.
	        int i=0; int j=numbers.size()-1;
	        List<Integer> odd=new ArrayList<Integer>();
	        List<Integer> even=new ArrayList<Integer>();
	        
	        while(i<=j){
	         if(i % 2 == 0 && j % 2 == 0){
	             even.add(numbers.get(i));
	             even.add(numbers.get(j));
	         } else if(i % 2 != 0 && j % 2 == 0) {
	              even.add(numbers.get(j));
	              odd.add(numbers.get(i));
	         } else if(i % 2 == 0 && j % 2 != 0) {
	              even.add(numbers.get(i));
	              odd.add(numbers.get(j));
	         } else {
	              odd.add(numbers.get(i));
	              odd.add(numbers.get(j));
	         }
	         
	         i++;j--;
	        }
	        
	        ArrayList<Integer> noDup = (ArrayList<Integer>) Stream.concat(odd.stream(),even.stream())
	                     .collect(Collectors.toList());
	        
	       return  noDup;
	        
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> nums=new ArrayList<Integer>();
		
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		
		ArrayList<Integer> result=segregate_evens_and_odds(nums);
		System.out.println(Arrays.toString(result.toArray()));		

	}

}
