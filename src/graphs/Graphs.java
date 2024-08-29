package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graphs {
	
	int n;
	Map<Integer, List<Integer>> map;
	
	  public void graph(int n, int[][] edges) {
    	  this.n=n;
    	  this.map=new HashMap<>();
    	  for(int i=0;i<n;i++) {
    		  map.put(i, new LinkedList());
    	  }
    	  
    	  for(int[] edge:edges) {
    		  map.get(edge[0]).add(edge[1]);
    	  }
    	  
      }
	  
	  public void bfs(int s) {
		  boolean[] visited=new boolean[n];
		  
		  Queue<Integer> queue=new LinkedList<>();
		  
//		  queue.
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
     
	}

}
