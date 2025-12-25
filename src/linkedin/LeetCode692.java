package linkedin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Top K word
 */

public class LeetCode692 {
    public static void main(String[] args) {
        String[] word = {"i","love","leetcode","i","love","coding"};
        for(String w : getTopK(word, 1)){
            System.out.print(w+",");
        }
    }

    private static List<String> getTopK(String[] words,int k){
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        Comparator<String> comparator = (a,b) ->map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b);

        PriorityQueue<String> pq = new PriorityQueue<>(comparator);
        for(String s: map.keySet()){
            pq.add(s);
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res.reversed();
    }
}
