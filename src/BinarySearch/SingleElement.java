package BinarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SingleElement {
    public static int singleNonDuplicate(int[] nums) {

        // Replace this placeholder return statement with your code
        Map<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else{
                map.put(nums[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{0,0,1,1,2,2,4,8,8,16,16,32,32}));

    }
}
