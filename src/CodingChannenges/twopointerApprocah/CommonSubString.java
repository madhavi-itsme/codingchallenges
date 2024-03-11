package CodingChannenges.twopointerApprocah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class CommonSubString {
	
	public static int binarySearch(int arr[],int l,int r, int x) {
		if(r>=1) {
			int mid=l+(r-1)/2;
			
			if(arr[mid] == x)
				return mid;
			if(arr[mid] > x)
				return binarySearch(arr,l,mid+1,x);
			
			return binarySearch(arr,mid+1,r,x);
		}
		return -1;
	}

    public static void commonSubstring(List<String> a, List<String> b) {
    // Write your code here
       for(int i=0;i<a.size();i++){
           char[] s1=a.get(i).toCharArray();
           char[] s2=b.get(i).toCharArray();
           int count =0;
           for(int j=0;j<s1.length;j++){
               for(int k=0;k<s2.length;k++){
                  if(s1[j] == s2[k]){
                      count++;
                      break;
                    }
                }
               
               if(count > 0){
            	   break;
               }
           }
           
           if(count ==1){
               System.out.println("YES");
           }else {
               System.out.println("NO");
           }
       }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//	        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//	        List<String> a = IntStream.range(0, aCount).mapToObj(i -> {
//	            try {
//	                return bufferedReader.readLine();
//	            } catch (IOException ex) {
//	                throw new RuntimeException(ex);
//	            }
//	        })
//	            .collect(toList());
//
//	        int bCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//	        List<String> b = IntStream.range(0, bCount).mapToObj(i -> {
//	            try {
//	                return bufferedReader.readLine();
//	            } catch (IOException ex) {
//	                throw new RuntimeException(ex);
//	            }
//	        })
//	            .collect(toList());

		 List<String> str1=new ArrayList<String>();
		 str1.add("hello");
		 str1.add("hi");
		 
		 List<String> str2=new ArrayList<String>();
		 str2.add("world");
		 str2.add("bye");
	        CommonSubString.commonSubstring(str1, str2);

//	        bufferedReader.close();
	}

}
