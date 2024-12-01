package leetCode;

import java.util.*;

public class LeetCode997 {
    public static void main(String[] args) {
        int[][] trusts = {{1,2}};
        int n = 2;

        System.out.println(judgeCount(trusts, n));
    }


    public static int judgeCount(int[][] trusts,int n){
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> inbound = new HashMap<>();
        Map<Integer,Integer> outBound = new HashMap<>();
        for(int i =0;i<trusts.length;i++){
            map.putIfAbsent(trusts[i][0], new ArrayList<>());
            map.get(trusts[i][0]).add(trusts[i][1]);
            inbound.put(trusts[i][1], inbound.getOrDefault(trusts[i][1],0)+1);
            outBound.put(trusts[i][0], inbound.getOrDefault(trusts[i][0],0)+1);
        }

        for(Map.Entry<Integer,Integer> map1:inbound.entrySet()){
            if(map1.getValue() == n-1 && !outBound.containsKey(map1.getKey())){
                return map1.getKey();
            }
        }



        return -1;

    }

}
