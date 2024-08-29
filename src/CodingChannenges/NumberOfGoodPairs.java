package CodingChannenges;

public class NumberOfGoodPairs {
	
	public int goodPairs(int[] arr) {
		int count=0;
		
		for(int i=0;i<=arr.length-1;i++) {
			for(int j=i+1;j<=arr.length-1;j++) {
				if(arr[i]==arr[j])
					count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfGoodPairs pairs=new NumberOfGoodPairs();
		int[] arr=new int[] {1,2,3,1,1,3};
		int[] arr1=new int[] {1,1,1,1};

		int[] arr2=new int[] {1,2,3};

		System.out.println(pairs.goodPairs(arr));
		System.out.println(pairs.goodPairs(arr1));
		System.out.println(pairs.goodPairs(arr2));

     
	}

}
