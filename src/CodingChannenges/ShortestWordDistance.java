package CodingChannenges;

public class ShortestWordDistance {
	
	public int shortestDistance(String[] words, String word1, String word2) {
		int dist=0;
		int source=0;
		int destination=0;
		
		dist= Math.abs(source-destination);

		
		for(int i=0;i<=words.length-1;i++) {
			if(words[i].equalsIgnoreCase(word1)) {
				source=i;
				
			}
			
			if(words[i].equalsIgnoreCase(word2)) {
				destination=i;
				
			}
			 			
			if(dist < Math.abs(source-destination)) {
				dist= Math.abs(source-destination);
			} else {
				dist= Math.abs(source-destination);
			}
		}
		
		return dist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words=new String[]{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
		ShortestWordDistance swd=new ShortestWordDistance();
		System.out.println(swd.shortestDistance(words, "fox", "dog"));
		
		String[] words1 = new String[]{"a", "c", "d", "b", "a"};
		
		String word1 = "a";
		
		String word2 = "b";
		
		System.out.println(swd.shortestDistance(words1, word1, word2));

	}

}
