import java.util.*;

public class ClosetElements {
    public static void findElements(int[] arr, int target, int n){
        Arrays.sort(arr);
        List<List<Integer>> heapList=new ArrayList<List<Integer>>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
         for(int i=0;i<arr.length;i++){
            if(Math.abs(target-arr[i]) > 0) {
                pq.add(new int[]{arr[i],Math.abs(target-arr[i])});
            }
        }
         List<Integer> result=new ArrayList<>();
         for(int i=0;i< n && !pq.isEmpty();i++){
             result.add(pq.poll()[0]);
         }
         System.out.println(result);
    }

    public static void main(String args[]){
        ClosetElements. findElements(new int[]{25,5,7,15,2,3,10}, 10,3);
    }

}
