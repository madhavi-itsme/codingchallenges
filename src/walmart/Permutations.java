package walmart;

import java.util.*;

public class Permutations {

    public void generatePermutations(String str){
        Set<String> res=new HashSet<>();

        if(str.isEmpty()){
            res.add("");
        }
        char[] stArr=str.toCharArray();
        for(char ch:stArr){

        }


    }

    public static void secondMax(int[] arr) {
        int max = 0;
        int secondMax = 0;
        if (arr[0] < arr[1])
            {
                max = arr[1];
                secondMax = arr[0];
            } else{
                max = arr[0];
                secondMax = arr[1];
            }
            for (int i = 2; i < arr.length ; i++) {
                if (arr[i] > max) {
                    secondMax=max;
                    max = arr[i];
                } else  if (arr[i] < max && arr[i] > secondMax) {
                    secondMax = arr[i];
                }
            }
            System.out.println("SecondMax: ------ " + secondMax);
        }

        public static void main(String args[]){
           int[] arr=new int[]{34,23,67,87,24,45};
            Permutations.secondMax(arr);
            Arrays.stream(arr).max();
            Permutations.secondMax(new int[]{1,2,3,4,5,6,7});
        }

    }


