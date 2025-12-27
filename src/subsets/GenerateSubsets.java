package subsets;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
*[1,2,3]
* []
* [1]
*
*
*
*
* */
public class GenerateSubsets {
    public static List<List<Integer>> genSubs(int[] arr){
        List<List<Integer>> list=new ArrayList<List<Integer>>();
         list.add(new ArrayList<Integer>());
        for(int i:arr){
            List<List<Integer>> newSubsets = new ArrayList<>();//            sublist.add(i);

            for(List<Integer> superSublist:list){
                List<Integer> sublist=new ArrayList<>(superSublist);
                sublist.add(i);
                newSubsets.add(sublist);
            }
            list.addAll(newSubsets);

        }
        return list;
    }

    public static void main(String args[]){
      List<List<Integer>> list=genSubs(new int[]{1,2,3});

      for(List<Integer> li:list){
          System.out.println("[");
          for(int i:li){
              System.out.println(i);
          }
          System.out.println("]");
      }
    }
}
