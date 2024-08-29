package CodingChannenges;

public class StandardDeviation {

	public static double calculateDeviation(int[] arr1 , double[] arr2){
        if(arr1.length != arr2.length)
            return 0.0;
        
         int meanSum=0;
        
            for(int i=0;i<arr1.length;i++){
                meanSum+=arr1[i];
            }
          float mean=meanSum/arr1.length;
	        int fsum=0;
	        for(int j=0;j<arr2.length;j++){
	            fsum+=arr2[j];
	        } 
	        int devSum=0;
	        for(int k=0;k<arr1.length;k++){
	            int temp= (int) Math.pow(Math.abs(arr1[k]-mean),2);
	          devSum+=arr2[k]*temp;
	        }    
	        double dev=0.0;   
	        dev=Math.sqrt(devSum / fsum); 
	        return dev;
        
    }
    public static void main(String[] args) {
        System.out.println(calculateDeviation(new int[] {1,2,3,4,5,6}, new double[] {2.0,3.0,4.0,5.0,6.0,7.0}));
    }
}
