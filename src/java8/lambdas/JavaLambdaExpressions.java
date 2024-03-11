package java8.lambdas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation
{
	boolean check(int a);
}
class Math{
		public static boolean checker(PerformOperation p ,int num){
   		return p.check(num);
		}
		
		PerformOperation isOdd()
	{
    	PerformOperation p =  (a) -> {return a%2==0 ? true:false;};
    
    	return p;
	}

    PerformOperation isPrime ()
    {
        PerformOperation p =  (a) -> { 
                                        if (a == 1) return false;
                                        for(int i = 2;i<a/2+1;i++){
                                            if((a%i)==0) return true; 
                                        }
                                        return true;
                                     };
        return p;
    }

    PerformOperation isPalindrome()
    {
        PerformOperation p =  (a) -> {
                                        String word = ""+a;
                                        boolean isPalindr = true;
                                        for(int i = 0;i<(int)word.length()/2;i++)
                                        {
                                            if(word.charAt(i) != word.charAt(word.length()-1-i)){
                                                isPalindr = false;
                                                break;

                                            }
                                        }
                                        return isPalindr?true:false;
                                     };
        return p;
    }	
}   

public class JavaLambdaExpressions {

public static void main(String[] args)throws IOException {
    Math ob = new Math();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T=Integer.parseInt(br.readLine());
    PerformOperation op;
    boolean ret =false;
    String ans=null;
    while(T-->0){
        String s=br.readLine().trim();
        StringTokenizer st=new StringTokenizer(s);
        int ch=Integer.parseInt(st.nextToken());
        int num=Integer.parseInt(st.nextToken());
        if(ch==1){
            op = ob.isOdd();  
            ret = Math.checker(op,num);
            ans = (ret)?"EVEN":"ODD";
        }
        else if(ch==2){
            op = ob.isPrime();
            ret = Math.checker(op,num);
            ans = (ret)?"PRIME":"COMPOSITE";
        }
        else if(ch==3){
            op = ob.isPalindrome();
            ret = Math.checker(op,num);
          	ans = (ret)?"PALINDROME":"NOT PALINDROME";

        }
        System.out.println(ans);
    }
}          
}
