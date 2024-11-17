package array;

import java.util.*;
import java.util.stream.Collectors;

public class MinAreaOfRectangle {

    public static void main(String[] args) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[][] a = {
                { 1, 1 },
                { 1, 3 },
                { 2, 2 },
                { 3, 1 },
                { 3, 3 },
                { 2, 2 }
        };

        
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            map.putIfAbsent(a[i][0], new HashSet<>());
            map.get(a[i][0]).add(a[i][1]);
        }
       
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i][0]+" : "+a[i][1]);
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int x1 = a[i][0];
                int y1 = a[i][1];
                int x2 = a[j][0];
                int y2 = a[j][1];
                if((map.containsKey(x1) && map.get(x1).size() <=1 )|| (map.containsKey(y2) && map.get(y2).size() <=1)){
                    continue;
                }
                if (x1 != x2 && y1 != y2) {
                    if (map.get(x1).contains(y2) && map.get(y2).contains(x1)) {
                        min = Math.min(min, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                    }
                }
            }
        }
        System.out.println(min);

    }

}
