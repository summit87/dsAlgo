package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class leetCode1466 {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] edge : edges){
            map.putIfAbsent(edge[0], map.getOrDefault(edge[0], new ArrayList<>()));
            map.putIfAbsent(edge[1], map.getOrDefault(edge[1], new ArrayList<>()));
            map.get(edge[0]).add(new int[]{edge[1],1});
            map.get(edge[1]).add(new int[]{edge[0],0});
        }

        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        set.add(0);
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            if(!map.containsKey(node) || map.get(node).isEmpty()){
                continue;
            }
            
            for(int[] n : map.get(node)){
                if(set.contains(n[0])){
                    continue;
                }
               cnt+=n[1];
                queue.add(n[0]);
                set.add(n[0]);
            }
        }

        System.out.println(cnt);
    }
}
