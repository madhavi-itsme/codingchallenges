package CodingChannenges.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBankOperations {
	public static void main(String args[]) throws IOException {
		BankOperations ops=new BankOperations();
		
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		
		 String count = reader.readLine();
		 int size=Integer.parseInt(count);
		
		 for(int i=0;i<size;i++) {
			 String temp=reader.readLine();
			 System.out.println(ops.performOperation(temp)); 
		 }
	}
}
