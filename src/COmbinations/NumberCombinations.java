package COmbinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumberCombinations {
    public static void combinations(int[] nums, int target){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int i=0;int j=1;
        int sum=nums[i];
        List<List<Integer>> result=new ArrayList<>();

        while(i<=j){
            sum+=nums[j];
            if(sum==target){
                List<Integer> list=new ArrayList<>();
                list.add(nums[i]);
                result.add(list);

                sum-=nums[i];
                i++;
            }else if(sum>target){
                do{
                    sum-=nums[i];
                    i++;
                } while(sum<target);

            }else if(sum<target){
                if(set.contains(target-sum)){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target-sum);
                    result.add(list);
                }
              j++;
            }
        }

        for(List<Integer> list:result){
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
    public static void main(String[] args) {
//        combinations(new int[]{1,2,3,4,5,6,7,8,9}, 9);
//        combinations(new int[]{2,3,6,7}, 7);
        combinations(new int[]{2,3,5}, 8);


    }
}
