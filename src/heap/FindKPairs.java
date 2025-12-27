package heap;

import java.util.*;

public class FindKPairs {
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {

        // Replace this placeholder return statement with your code

        // Sort both the lists.
        // iterate each list and make pairs and add the value with the Minheap ,
        // if that total is equal to the k return to that.

        int[] maxlist;
        int[] minlist;

        if(list1.length > list2.length){
            maxlist = new int[list1.length];
            maxlist=list1;
            minlist = new int[list2.length];
            minlist=list2;
        } else {
            maxlist = new int[list2.length];
            maxlist=list2;
            minlist = new int[list1.length];
            minlist=list1;
        }
        List<List<Integer>> result=new ArrayList<List<Integer>>();

        List<List<Integer>> finalList=new ArrayList<List<Integer>>();

        PriorityQueue<Integer> queue= new PriorityQueue<>();

        for(int i=0;i<maxlist.length;i++){
            for(int j=0;j<minlist.length;j++){
                List<Integer> list=new ArrayList<>();
                list.add(maxlist[i]);
                list.add(minlist[j]);
                finalList.add(list);
                int sum=maxlist[i]+minlist[j];
                {
                    queue.add(sum);
                }

            }
        }
        finalList.sort(Comparator.comparingInt(e -> e.get(0)));

        while(!queue.isEmpty() && target !=0){
            int temp= queue.poll();
            for(List<Integer> list:finalList){
                if(list.get(0)+list.get(1)==temp){
                    result.add(list);
                    target--;
                    break;
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> kSmallestPairsNaiveApproach(int[] list1, int[] list2, int target) {

        // Replace this placeholder return statement with your code

        // Sort both the lists.
        // iterate each list and make pairs and add the value with the Minheap ,
        // if that total is equal to the k return to that.

        int[] maxlist;
        int[] minlist;

        if(list1.length > list2.length){
            maxlist = new int[list1.length];
            maxlist=list1;
            minlist = new int[list2.length];
            minlist=list2;
        } else {
            maxlist = new int[list2.length];
            maxlist=list2;
            minlist = new int[list1.length];
            minlist=list1;
        }
        List<List<Integer>> result=new ArrayList<List<Integer>>();


        PriorityQueue<int[]> queue= new PriorityQueue<>(Comparator.comparingInt(a->a[2]));

        for(int i=0;i<maxlist.length;i++){
            for(int j=0;j<minlist.length;j++){
                    queue.add(new int[]{maxlist[i],minlist[j],maxlist[i]+minlist[j]});
            }
        }

        while(!queue.isEmpty() && target > 0){
            int[] temp= queue.poll();
                    List<Integer> list=new ArrayList<>();
                    list.add(temp[0]);
                    list.add(temp[1]);
                    result.add(list);
                    target--;
        }


        for(List<Integer> list:result){
            System.out.println("["+list.get(0) + "," + list.get(1)+"]");
        }
        return result;
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{1,2,300};
        int[] list2 = new int[]{1,11,20,35,300};
        FindKPairs.kSmallestPairsNaiveApproach(list1, list2, 5);
    }
}
