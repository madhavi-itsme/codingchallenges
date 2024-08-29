package CodingChannenges.hackerrank;

import java.util.Arrays;
import java.util.List;

public class BankOperations implements IBankOperations{

	double result=0.0;
	 String[] depoit=new String[] {"invest","put"};
	 String[] bal=new String[] {"see","check"};
	 String[] with=new String[] {"get","take"};
	List<String> deposit= Arrays.asList(depoit);
	List<String> balance= Arrays.asList(bal);
	List<String> withdraw= Arrays.asList(with);

	
	@Override
	public double depotamount(double d) {
		// TODO Auto-generated method stub
		result+=d;
		return result;
	}

	@Override
	public double withDraw(double d) {
		// TODO Auto-generated method stub
		result-=d;
		return Math.abs(result);
	}
	
	public double getAmount(String str) {
		double amount=0;
		char[] tokens=str.toCharArray();
		StringBuffer buffer=new StringBuffer();
		
		for(char ch:tokens) {
			buffer.append(ch);
		}		
		amount=Double.parseDouble(buffer.toString());
		return amount;
	}

	@Override
	public double performOperation(String str) {
		// TODO Auto-generated method stub
		double temp=0.0;
		StringBuffer buffer=new StringBuffer();
		int process=0;
		
		String[] tokens=str.split("\\s");
		
		for(String token:tokens) {
			char ch=token.charAt(0);
			
			if(Character.isDigit(ch)) {
				temp=getAmount(token);
			}else {
				if(deposit.contains(token)) {
					process=1;
				}else if(balance.contains(token)) {
					process=2;
				}else if(withdraw.contains(token)) {
					process=3;	
				}
			}
		}
		System.out.println("process"+process);
		if(process ==1) {
			depotamount(temp);
		}else if(process ==2){
			return result;
		}else if(process ==3){
			withDraw(temp);
		}	
		
		return result;
	}
}
