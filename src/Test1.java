/**
 *There is a string of length N made only of letters "a". Whenever there are two identical adjacent letters (e.g. "aa"),
 *  they can be transformed into a single letter that is the next letter of the alphabet. For example,
 *  "aa" can be transformed into "b" and "ee" into "f". However, "zz" cannot be further transformed.
 *
 *
 * What is the alphabetically largest string that can be obtained from the initial string?
 *
 *
 * Write a function:
 *
 *
 * String  solution(int N);
 *
 *
 * that, given an integer N, returns the alphabetically largest string that can be obtained after such transformations.
 *
 *
 * Examples:
 *
 *
 * 1. Given N = 11, the function should return "dba". The initial string "aaaaaaaaaaa" can be transformed in the following manner: "aaaaaaaaaaa" → "bbbbba" → "ccba" → "dba".
 *
 * aa aa aa aa aa a
 *  b b  b  b  b  a
 *  c     c    b a
 *     d      b a
 *
  * 2. Given N = 1, the function should return "a". The initial string "a" cannot be transformed in any way.
 *
 *    base case -- N ==1 return a.

 * 3. Given N = 67108876, the function should return "zzdc".
 */


public class Test1 {

    public static String  solution(int N){

        if(N ==1 ){
            return "a";
        }

        StringBuilder result=new StringBuilder();

        int pow=0;
        long max= 1L << 25;

        if (N >= max){
            int count=(int) (N / max);
            N %= max;

            for(int i=0;i< count;i++) {
                result.append('Z');
            }

        }

        while(N > 0){
            if((N & 1) == 1){
                char letter=(char) ('a' + pow);
                result.insert(0,letter);
            }
            N >>= 1 ;
            pow++;

        }
        return result.toString();
    }


    public static String solution1(long N) {
        StringBuilder sb = new StringBuilder();

        // Start from largest letter 'z' (2^25) down to 'a' (2^0)
        for (int i = 25; i >= 0; i--) {
            long power = 1L << i; // 2^i
            if (N >= power) {
                long count = N / power;  // how many times this letter appears
                for (long j = 0; j < count; j++) {
                    sb.append((char)('a' + i));
                }
                N -= power * count;
            }
        }

        return sb.toString();
    }


    public static void main(String args[]){

        System.out.println(solution1(1));

        System.out.println(solution1(11));

        System.out.println(solution1(50));

        System.out.println(solution1(67108876));


    }


}
