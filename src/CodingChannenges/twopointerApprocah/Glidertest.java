//package CodingChannenges.twopointerApprocah;
//
//public class Glidertest {
//
//	// Click on "HELP" above to see examples of handling input/debug/output 
//	// Format the output as specified in the problem statement and write the result to stdout 
//	// IMPORTANT: Remove all debug statements for your final submission
//	import java.util.*;
//	import java.lang.*;
//	import java.io.*;
//
//	class Node
//	{
//		int data;
//		Node left, right, nextRight;
//		
//		Node(int value){
//			data = value;
//			left = null;
//			right = null;
//			nextRight = null;
//		}
//		
//	}
//
//	class BT
//	{
//		Node root;
//	    Map<Integer, Node> dangling = new HashMap<>();
//
//	    void addNode(int parent, int child, char direction) {
//	        Node childNode, parentNode;
//	        if (!dangling.containsKey(child)) {
//	            childNode = new Node(child);
//	            dangling.put(child, childNode);
//	        } 
//	        else {
//	            childNode = dangling.get(child);
//	        }
//
//	        if (!dangling.containsKey(parent)) {
//	            parentNode = new Node(parent);
//	            dangling.put(parent, parentNode);
//	        } 
//	        else {
//	            parentNode = dangling.get(parent);
//	        }
//
//	        if (root == null) {
//	            root = parentNode;
//	        }
//	        
//	        if (direction == 'L') {
//	            parentNode.left = childNode;
//	        } 
//	        else {
//	            parentNode.right = childNode;
//	        }
//	    }
//
//		int[] getLevelSpiral(){
//				int[] levelSpiral = {1,2,3};
//				// Write your code here
//				
//				Enque<Node> list=new LinkedList<Node>();
//				Node head=dangling.get(0);
//				
//				
//				
//				return levelSpiral;
//			}
//
//	}
//
//	class Solution
//	{
//		public static void main (String[] args) throws java.lang.Exception
//		{
//			BT bt = new BT();
//			Scanner in = new Scanner(System.in);
//			int edges, parent, child;
//			char direction;
//			int[] levelSpiral;
//			edges = in.nextInt();		
//			for(int i=0; i<edges; i++){
//				parent = in.nextInt();
//				child = in.nextInt();
//				direction = in.next().charAt(0);
//				bt.addNode(parent, child, direction);
//			}
//			levelSpiral = bt.getLevelSpiral();
//			for (int i=0; i<levelSpiral.length; i++){
//				System.out.print(levelSpiral[i]+" ");
//			}
//		}
//	}
//
//}
