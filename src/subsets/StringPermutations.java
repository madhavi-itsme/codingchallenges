package subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* abc acb
* bac bca
* cab cba
*
*
*
*
*
* */
public class StringPermutations {
    public static Set<String> genSubs(String str){
        Set<String> list=new HashSet<String>();
        char[] charArrays=str.toCharArray();
        int j=0;
        for(int i=0;i<str.length();i++){

            String temp=str;
            temp.replace(str.charAt(i),charArrays[j]);
            list.add(temp);
        }

        return list;
    }

    public static void main(String args[]){
        Set<String> list=genSubs("abc");

        for(String li:list){
                System.out.println(li);
        }
    }
}
