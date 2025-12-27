package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TwoHeaps {
    public static void main(String[] args) {
        int[][] tasks = {
                {1, 1},
                {5, 5},
                {8, 8},
                {4, 4},
                {6, 6},
                {10, 10},
                {7, 7}
        };

        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

        for (int[] task : tasks) {
            System.out.println(Arrays.toString(task));
        }

    }
}
