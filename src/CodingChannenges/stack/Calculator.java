package CodingChannenges.stack;

public class Calculator {
    public boolean braces= false;
	public  int evaluateExpression(String str) {
		 int result=0;
		 int number =0;
		 int sign=0;
		 
		 for(char ch:str.toCharArray()) {
			 if(Character.isDigit(ch)) {
				 result=ch;
			 }else if(ch == '+' || ch == '-' || ch == '*') {
				 result= result + ch;
			 } else if(ch == '(') {
				 braces=true;
				 
				 
			 }
			 
		 }
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String str="4 + (52 - 12) + 99";
      Calculator cl=new Calculator();
      System.out.println(cl.evaluateExpression(str));
	}

}
