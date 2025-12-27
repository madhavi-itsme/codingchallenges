package mergeintervals;
import java.util.*;
/*
[1,3], [5,7],[8,9],[10,13]

[2,6]


*/
class InsertInterval {

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {

        // Replace this placeholder return statement with your code
        LinkedList<int[]> result=new LinkedList<int[]>();

        result.add(existingIntervals[0]);

        boolean inserted=false;

        for(int i=1;i<existingIntervals.length;i++){
            int[]lastInterval=result.getLast();
            int[] current=existingIntervals[i];
            if(!inserted ){
                if(lastInterval[1] > newInterval[0]){
                    lastInterval[1]=newInterval[1];
                    result.add(i-1, lastInterval);
                } else {
                    result.add(existingIntervals[i]);
                }
            } else {
                if(lastInterval[1] > current[0]){
                    lastInterval[1]=current[1];
                    result.add(i-1, lastInterval);
                } else {
                    result.add(existingIntervals[i]);
                }
            }

        }

        return (int[][]) result.toArray();
    }

    public static int[][] insertInterval2(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        int i = 0, n = intervals.length;

        // Step 1: Add all intervals before newInterval (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Add the merged interval

        // Step 3: Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args){
//        System.out.println(insertInterval2(new int[[1,3], [5,7],[8,9],[10,13]{}]);
    }
}