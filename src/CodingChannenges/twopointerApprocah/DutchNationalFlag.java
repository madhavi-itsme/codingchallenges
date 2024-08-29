package CodingChannenges.twopointerApprocah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DutchNationalFlag {
	
	public  static void printUnsorted(int arr[], int n)
    {
	      int s = 0, e = n-1, i, max, min;   
	       
	      // step 1(a) of above algo
	      for (s = 0; s < n-1; s++)
	      {
	        if (arr[s] > arr[s+1])
	          break;
	      }
	      if (s == n-1)
	      {
	        System.out.println("The complete array is sorted");
	        return;
	      }
	       
	      // step 1(b) of above algo
	      for(e = n - 1; e > 0; e--)
	      {
	        if(arr[e] < arr[e-1])
	          break;
	      }
	       
	      // step 2(a) of above algo
	      max = arr[s]; min = arr[s];
	      for(i = s + 1; i <= e; i++)
	      {
	        if(arr[i] > max)
	          max = arr[i];
	        if(arr[i] < min)
	          min = arr[i];
	      }
	       
	      // step 2(b) of above algo
	      for( i = 0; i < s; i++)
	      {
	        if(arr[i] > min)
	        {  
	          s = i;
	          break;
	        }      
	      } 
	       
	      // step 2(c) of above algo
	      for( i = n -1; i >= e+1; i--)
	      {
	        if(arr[i] < max)
	        {
	          e = i;
	          break;
	        } 
	      }  
	           
	      // step 3 of above algo
	      System.out.println(" The unsorted subarray which"+
	                         " makes the given array sorted lies"+
	                       "  between the indices "+s+" and "+e);
	      return;
	    }
	
	public static void minimumSort(int[] a) {
		
		// TODO Auto-generated method stub
		int minIndex=0;
		int maxIndex=0;	
		
           for(int i=0;i<a.length-1;i++) {
        	   if(a[i] > a[i+1]) {
        		   minIndex=a[i];
        		   break;
        	   }       	  
           }   
           
           System.out.println(minIndex);
           
           for(int j=a.length-1;j>=0;j--) {
        	   if(a[j] < a[j-1]) {
        		   maxIndex=a[j];
        		   break;    
        	   }     	  
           }    
           int[] temp=a;
           
           Arrays.sort(temp);
           int startIndex=0;
           int endIndex=0;
           
          int i=0;
          int j= temp.length-1;
          while(i<=j) {
        	  if(a[i] < minIndex) {
        		  startIndex=i;
        		  break;
        	  }
        	  i++;
          }	  
	     
	
	     while(j>=0) {
        	  if(a[j] < maxIndex) {
        		  endIndex=j;
        		  break;
        	  }
        	  j--;      		  
          }        
          System.out.println("The subarray to be sorted is ...."+(Math.abs(endIndex)-Math.abs(startIndex)+1));          
	}
	
	public static int[] transformArray(int[] arr) {
		
		if(arr.length == 1) 
			return arr;
		
		int i=0;int j=arr.length-1;
		
		while(i<=j) {
			
         if(arr[i] > arr[j]) {
        	 int temp=arr[i];
        	 arr[i]=arr[j];
        	 arr[j]=temp;
         } else if(arr[i] < arr[j]) {
        	 i++;
         } else if(arr[i] == arr[j]){
        	 j--;
         }
		}
		return arr;		
	}
	
public static int[] transformArray3Pointer(int[] arr) {
		
		int l=0;
		int m=0;
		int h=arr.length-1;
		
		while(m<=h) {
			if(arr[m] == 2) {
				swap(arr,m,h);
				h--;
			} else 
			
			if(arr[m] == 0) {
				swap(arr,l,m);
				l++;
				m++;
			} else 
			
			if(arr[m] ==1) {
				m++;
			}	
		}
		return arr;		
	}

	public static void swap(int[] arr , int i,int j) {
		 int temp=arr[i];
		 arr[i]=arr[j];
		 arr[j]=temp;
	}
	
	
public static char[] transformArray3Pointerch(char[] arr) {
		
		int l=0;
		int m=0;
		int h=arr.length-1;
		
		while(m<=h) {
			if(arr[m] == 'B') {
				swapch(arr,m,h);
				h--;
			} else 
			
			if(arr[m] == 'R') {
				swapch(arr,l,m);
				l++;
				m++;
			} else 
			
			if(arr[m] =='G') {
				m++;
			}	
		}
		return arr;		
	}

	public static void swapch(char[] arr , int i,int j) {
		char temp=arr[i];
		 arr[i]=arr[j];
		 arr[j]=temp;
	}
	
	
	public static List<Character> dutch_flag_sort(List<Character> result2) {
	        // Write your code here.
	        
	        List<Character> result=new ArrayList<Character>();
	        List<Character> result1=new ArrayList<Character>();

	          List<Character> glist=new ArrayList<Character>();
	        List<Character> blist=new ArrayList<Character>();
	        List<Character> rlist=new ArrayList<Character>();
	        for(char ch:result2){
	            if (ch == 'G') 
	                glist.add('G');
	            else if(ch == 'R')
	                 rlist.add('R');
	            else if(ch == 'B')
	                 blist.add('B');
	        }
	        result=Stream.concat(rlist.stream(),glist.stream()).collect(Collectors.toList());
	        
	        result1=Stream.concat(result.stream(),blist.stream()).collect(Collectors.toList());

	        System.out.println(Arrays.toString(result1.toArray()));
	        return result1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DutchNationalFlag dn=new DutchNationalFlag();
		System.out.println(Arrays.toString(DutchNationalFlag.transformArray(new int[] {1, 0, 2, 1, 0})));
		System.out.println(Arrays.toString(DutchNationalFlag.transformArray(new int[] {2, 2, 0, 1, 2, 0})));
		System.out.println(Arrays.toString(DutchNationalFlag.transformArray3Pointer(new int[] {2, 2, 0, 1, 2, 0})));
		System.out.println(Arrays.toString(DutchNationalFlag.transformArray3Pointer(new int[] {0})));
		System.out.println(Arrays.toString(DutchNationalFlag.transformArray3Pointer(new int[] {1})));
		DutchNationalFlag.minimumSort(new int[] {1, 2, 5, 3, 7, 10, 9, 12});         
		DutchNationalFlag.minimumSort(new int[] {1, 3, 2, 0, -1, 7, 10});  
		DutchNationalFlag.printUnsorted(new int[] {1, 3, 2, 0, -1, 7, 10},7);  
        List<Character> result=new ArrayList<Character>();
        result.add('R');
        
        result.add('G');

        result.add('G');

        
        result.add('R');
        result.add('G');
        result.add('B');
        result.add('G');
        result.add('R');
        result.add('R');
        result.add('R');
        result.add('G');


        System.out.println(Arrays.toString(DutchNationalFlag.transformArray3Pointerch(new char[] {'G','B','R','R','B','R','G'})));
		

	}

}
