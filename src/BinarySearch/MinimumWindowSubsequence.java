package BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class MinimumWindowSubsequence {
    public static String minWindow(String str1, String str2) {
        String result = "";
        int minLength = Integer.MAX_VALUE, s2Index = 0;

        for (int i = 0; i < str1.length(); i++) {
            // Update `s2Index` when a matching character is found
            if (str1.charAt(i) == str2.charAt(s2Index)) {
                s2Index++;
            }

            // When `s2Index` reaches the end of str2
            if (s2Index == str2.length()) {
                int end = i + 1;
                s2Index--;

                // Move backward through str1 until the subsequence is found
                while (s2Index >= 0) {
                    if (str1.charAt(i) == str2.charAt(s2Index)) {
                        s2Index--;
                    }
                    i--;
                }

                i++;
                s2Index = 0;

                // Missing Logic
            }
        }
        return result;
    }

    public static void mergeIntervals(int[][] intervals , int[] newInterval) {

        Stack<int[]> stack = new Stack<>();
        boolean isIntervalMerged = false;
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
                int[] lastInterval = stack.peek();
                int[] interval = intervals[i];
                if(!isIntervalMerged) {
                    if(lastInterval[1] >= newInterval[0]) {
                         stack.pop();
                         stack.push(new int[]{lastInterval[0],newInterval[1]});
                         isIntervalMerged = true;
                    } else {
                        stack.push(interval);
                    }
                } else {
                    if(lastInterval[1] >= interval[0]) {
                        stack.pop();
                        stack.push(new int[]{lastInterval[0],interval[1]});
                    } else{
                        stack.push(interval);
                    }
                }
        }
        int[][] result= new int[stack.size()][stack.size()];
        int i = 0;
        for(int[] interval : stack) {
            result[i]=interval;
            System.out.println(Arrays.toString(result[i]));
            i++;
        }

//          int[][] result1 = (int[][]) stack.toArray();

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
    public static void main(String[] args) {


        mergeIntervals(new int[][]{{1,3},  {6,9}}, new int[]{2,5});

        mergeIntervals(new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}}, new int[]{4,8});

        insertInterval2(new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}}, new int[]{4,8});

    }
}