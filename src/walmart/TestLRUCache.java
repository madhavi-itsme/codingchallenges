package walmart;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestLRUCache {
    public static void main(String args[]){
        String[] commands = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] values = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

        List<Integer> output = new ArrayList<>();

        LRUCache cache=null;

        for(int i=0;i<commands.length;i++){
            switch (commands[i]){
                case "LRUCache":
                    cache=new LRUCache(values[i][0]);
                    output.add(null);
                    break;
                case "put":
                    cache.put(values[i][0],values[i][1]);
                    output.add(null);
                    break;
                case "get":
                    output.add(cache.get(values[i][0]));
                    break;
            }
        }
       System.out.println(output);
    }
}
