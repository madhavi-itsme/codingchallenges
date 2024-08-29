package CodingChannenges.hackerrank;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Solution {

	public static String getMD(String input){
	    
        String hashtext = null;
	    try{
	         MessageDigest md=MessageDigest.getInstance("MD5");
	          byte[] messageDigest = md.digest(input.getBytes());
	          BigInteger no = new BigInteger(1, messageDigest);
	          hashtext = no.toString(16);
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	       } catch(NoSuchAlgorithmException ex){
	           throw new RuntimeException(ex);
	       }
	    return hashtext;
	}
	
public static String getSha256(String input){
	    
        String hashtext = null;
	    try{
	         MessageDigest md=MessageDigest.getInstance("SHA-256");
	          byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
	          BigInteger no = new BigInteger(1, messageDigest);
	          hashtext = no.toString(16);
	            while (hashtext.length() < 64) {
	                hashtext = "0" + hashtext;
	            }
	       } catch(NoSuchAlgorithmException ex){
	           throw new RuntimeException(ex);
	       }
	    return hashtext;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String input="HelloWorld";
         System.out.println(Md5Solution.getMD(input));
         System.out.println(Md5Solution.getSha256(input));

	}

}
