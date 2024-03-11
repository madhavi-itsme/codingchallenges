package CodingChannenges.twopointerApprocah;

public class BackSpaceStringComparision {
	
	public static boolean compareStrings(String str1 ,String str2) {
		
		return getActualString(str1).equalsIgnoreCase(getActualString(str2));
		
	}
	
	public static String getActualString(String str1) {
		int count=0;
		StringBuilder sb1=new StringBuilder();
		
		for(int i=str1.length()-1;i>=0;i--) {
			if(str1.charAt(i) == '#') {
				count++;
				continue;
			} 
			
			if(count>0) {
				count--;
			} else {
				sb1.insert(0, str1.charAt(i));
			}
		}
	 return sb1.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
     System.out.println(BackSpaceStringComparision.compareStrings("xy#z","xzz#"));
     
     System.out.println(BackSpaceStringComparision.compareStrings("xy#z","xyz#"));

     
	}

}
