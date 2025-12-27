package parkinglot;

import java.io.*;
import java.util.*;

/*
 Write a progam to find the word from the sequence from a file
 */
public class Sample1 {

    public boolean anagram(String str1, String str2){
        // listen  -- silent

        String str1Sort=sort(str1);
        String str2Stort=sort(str2);

        for(int i=0;i< str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i))
                return false;
        }
        return true;
    }

    public String sort(String str1){
        char[] charArray=str1.toCharArray();
        Arrays.sort(charArray);
        return  charArray.toString();
    }

    public static void main(String args[]) throws IOException {
        File file=new File("/sample.txt");
        FileInputStream str=new FileInputStream(file);
        BufferedInputStream stream=new BufferedInputStream(str);

        String sample= stream.toString();

       String[]  strArray=sample.split(" ");
        Map<String, Integer> map=new HashMap<>();
        int maxCount=0;
        String word="";
        for(String st:strArray){
           if(map.get(st) !=null){
               int temp=map.get(st)+1;
               if(temp > maxCount){

               }
           }
        }






    }
}
