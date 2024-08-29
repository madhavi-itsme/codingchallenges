package java8.lambdas;

public class CursorMoves extends MouseMoves{
  static  String scrollUp = "String in B";
 static  int up = 1;
 
 
 void overload() {
		System.out.println(MouseMoves.scrollUp);

		System.out.println(CursorMoves.scrollUp);
	}
 
 public static void main(String args[]) {
	 System.out.println(MouseMoves.scrollUp);

		System.out.println(CursorMoves.scrollUp);

 }
 
}
