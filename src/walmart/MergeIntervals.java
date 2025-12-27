package walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    public static void merge(List<List<Integer>> intervals){

        int i=1;
        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        List<List<Integer>> result=new ArrayList<>();
        if(intervals.isEmpty()){
            result.add(Arrays.asList(new Integer[]{}));
        } else {
            result.add(intervals.get(0));
        }


        while(i < intervals.size()){
            List<Integer> current=intervals.get(i);
            List<Integer> last=result.get(result.size() - 1);

            if(current.get(0) <= last.get(1)){
                int temp=Math.max(current.get(1),last.get(1));
                result.remove(result.size() - 1);
                result.add(Arrays.asList(last.get(0),temp));
            } else {
                result.add(current);
            }
            i++;
        }

        System.out.println(Arrays.toString(result.toArray()));
    }
    public static void main(String args[]){
        List<List<Integer>> list=new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{1,3}));
        list.add(Arrays.asList(new Integer[]{2,6}));
        list.add(Arrays.asList(new Integer[]{8,10}));
        list.add(Arrays.asList(new Integer[]{15,18}));

        MergeIntervals.merge(list);

        List<List<Integer>> list1=new ArrayList<>();
        list1.add(Arrays.asList(new Integer[]{}));

        MergeIntervals.merge(list1);

        List<List<Integer>> list2=new ArrayList<>();
        list2.add(Arrays.asList(new Integer[]{5,10}));

        MergeIntervals.merge(list2);

        List<List<Integer>> list3=new ArrayList<>();
        list3.add(Arrays.asList(new Integer[]{5,10}));
        list3.add(Arrays.asList(new Integer[]{6,8}));
        list3.add(Arrays.asList(new Integer[]{1,5}));
        list3.add(Arrays.asList(new Integer[]{2,3}));
        list3.add(Arrays.asList(new Integer[]{1,10}));

        MergeIntervals.merge(list3);

        List<List<Integer>> list4=new ArrayList<>();
        list4.add(Arrays.asList(new Integer[]{-15,-10}));
        list4.add(Arrays.asList(new Integer[]{-6,8}));
        list4.add(Arrays.asList(new Integer[]{-1,5}));
        list4.add(Arrays.asList(new Integer[]{2,3}));
        list4.add(Arrays.asList(new Integer[]{-1,10}));

        MergeIntervals.merge(list4);

    }
}
