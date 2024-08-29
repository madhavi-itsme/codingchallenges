package CodingChannenges.twopointerApprocah;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CanDyCrush1D {
	static StringBuffer result;
	
	public static String solution(String str) {
		int i=0;
		while(i<str.length()) {
			if(str.charAt(i) != str.charAt(i+1)) {
				result.append(str.charAt(i));
				i++;
			}
			
			if(i != str.length() && str.charAt(i) == str.charAt(i+1)) {
				while(i != str.length() && str.charAt(i) == str.charAt(i+1)) {
					i++;
				}
				i++;
			}
		}
		
		return result.toString();
	}
	
	public static String findSol(String str,int i,int j, int count) {
		
         if(str.length() <= 1) {
        	 return str.toString();
         }
         int k=0;int m=k+1;
         
//          do {
            while(count<str.length()) {
            	 if(str.charAt(k) == str.charAt(m)) {
                 	 count++;
                 	 if(count == 3) {
//                 		 str.delete(k, m);
                 		 findSol(str.substring(m, str.length()),i,j,count);
                 	 }
                 	 m++;
                  } else {
                 	 count= 1;
                 	 findSol(str,i+1,j+1,count);
                  } 	
            }
        	  
//          }while(count == 0);
        	 
		return str.toString();
	}
	
	public static void findSolWithStack(String str) {
		
		Stack<Character> stack=new Stack<Character>();
		
		Stack<Integer> times=new Stack<Integer>();
		
		for(Character ch: str.toCharArray()) {
			if(!stack.isEmpty()) {
				if(stack.peek() == ch && times.peek() < 3) {
					int temp=times.peek();
					temp+=1;
					if(temp == 3) {
						for(int i=0;i<2;i++) {
							stack.pop();
							times.pop();
						}
					} else {
						stack.push(ch);					
						times.push(temp);
					}
					
				} else if(stack.peek() != ch){
					stack.push(ch);
					times.push(1);
				}
			} else {
				stack.push(ch);
				times.push(1);
			}
		}
		
		
		StringBuilder sb=new StringBuilder();
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.reverse().toString());
		
	}


	public static void main(String[] args) {

		CanDyCrush1D.findSolWithStack("aabbcccf");  //aabbf
		
		CanDyCrush1D.findSolWithStack("aaabbbc"); // c
		
		CanDyCrush1D.findSolWithStack("aabbbacd"); // cd
		
		CanDyCrush1D.findSolWithStack("aabbccddeeedcba"); // "" 
		
		CanDyCrush1D.findSolWithStack("aaabbbacd"); // acd
		
		
		
		
		String str="She sells sea shells";
		String rex="SsS";
		String replace="X";
		
		Pattern p=Pattern.compile(rex);
		Matcher m=p.matcher(str);
		
		String val=m.replaceAll(replace);
		
		System.out.println(val);
		
		
	}

}
