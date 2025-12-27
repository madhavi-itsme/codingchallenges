package subsets;

import java.util.*;

public class LetterCombination {

    public static Map<Integer, String> getMap(){
        Map<Integer, String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        return map;
    }
    public static List<String> combinaations(int num){

       List<String> listOne=new ArrayList<String>();
        List<String> result=new ArrayList<>();
        Map<Integer,String> map=getMap();

        String numberStr = String.valueOf(num);
        for (int i = 0; i < numberStr.length(); i++) {
            char digitChar = numberStr.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            listOne.add(map.get(digit));
            System.out.println(digit);
        }

        if (listOne.size() == 1) {
            for(char ch:listOne.get(0).toCharArray()){
                result.add(String.valueOf(ch));
            }
            return result;
        }
       char[] ch1=listOne.get(0).toCharArray();
        char[] ch2=listOne.get(1).toCharArray();

        for(char ch:ch1){
            for(char ch3:ch2){
                result.add(String.valueOf(ch)+String.valueOf(ch3));
            }
        }
        return result;
    }
    public static void main(String args[]){
        List<String> list=combinaations(23);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
