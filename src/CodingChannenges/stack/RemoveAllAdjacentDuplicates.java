package CodingChannenges.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
	
	public static String removeDuplicates(String s) {

        // Replace this placeholder return statement with your code
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
        	if(stack.size() > 0 ) {
        		if(s.charAt(i)!=stack.peek()) {
        			stack.push(s.charAt(i));
            	} else {
            		stack.pop();
            	}
        	}else {
        		stack.push(s.charAt(i));
        	}
        }
        
        StringBuilder builder=new StringBuilder();
        
        while(!stack.isEmpty()) {
        	builder.append(stack.pop());
        }
        return builder.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(removeDuplicates("ggaabcdeb"));
	}

}
