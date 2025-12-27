import java.util.*;
import java.util.stream.Collectors;

public class Fileter {
    public static void main(String[] args){
        List<Integer> arr=Arrays.asList(2,3,4,2,5);
        List<Integer> list=new ArrayList<>();
        int max = arr.stream().max(Integer::compareTo).get();
        System.out.println("max: "+max);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = arr.stream()
                .filter(n -> !seen.add(n))  // Set.add returns false if already present
                .collect(Collectors.toSet());

        System.out.println(Arrays.toString(seen.toArray()));

    }
}
