package CodingChannenges.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LinkedListOperations {

	public static int sizeOfLinedList() {
		
		return 0;
		
	}
	
	 public static List<String> mostActive(List<String> customers) {
		    // Write your code here
		    Map<String, Integer> map=new HashMap<String,Integer>();
		    
		       for(int i=0;i<customers.size();i++){
		           if(map.get(customers.get(i)) == null){
		               map.put(customers.get(i),1);
		           } else {
		               int k=map.get(customers.get(i));
		                map.put(customers.get(i),k+1);
		           }
		       }
		       
		       Set<String> result=new HashSet<String>();
		       int size=customers.size();
		       for(String name:map.keySet()){
		           int j=map.get(name);
		           double fr=((double)j * 100 / (double)size) ;
		           System.out.println("name: "+name+ " : "+fr);
		           if(fr > 5){
		               result.add(name);
		           }
		       }
		   	System.out.println(result.size());

		     return new ArrayList<>(result);
		    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> customers=new ArrayList<String>();
		
		customers.add("BigCorp");
		customers.add("BigCorp");

		customers.add("BigCorp");

		customers.add("BigCorp");

		customers.add("BigCorp");

		customers.add("BigCorp");

		customers.add("BigCorp");

		customers.add("BigCorp");

		
		customers.add("BigCorp");

		customers.add("BigCorp");


	
		customers.add("Acme");
		customers.add("Acme");

		customers.add("Acme");

		customers.add("Acme");

		customers.add("Acme");

		customers.add("Zork");

		customers.add("Zork");

		
		customers.add("Zork");

		customers.add("Zork");

		customers.add("Zork");
		
		customers.add("LittleCorp");

		customers.add("Madir");
		customers.add("abc");

	       System.out.println(LinkedListOperations.mostActive(customers).toArray().toString());
		
	}

}
