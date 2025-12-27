package stack;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();

        for(String s:tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand

                switch (s) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break; // Integer division
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
    public static void main(String[] args) {
        EvalRPN e=new EvalRPN();
        System.out.println(e.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(e.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
