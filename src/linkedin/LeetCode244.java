package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode244 {

    /**
     * Shortest distance
     * 
     * @param args
     */
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        String[] word = {"practice", "makes", "perfect", "coding", "makes"};
        for (int x = 0; x < word.length; x++) {
            map.putIfAbsent(word[x], map.getOrDefault(word[x], new ArrayList<>()));
            map.get(word[x]).add(x);
        }
         String[] query = {"coding", "practice"};
        int dist = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(query[0]);
        List<Integer> list2 = map.get(query[1]);
        int ind1 = 0;
        int ind2 = 0;
        while(ind1 < list1.size() && ind2 < list2.size()){
            dist = Math.min(dist, Math.abs(list1.get(ind1) - list2.get(ind2)));
            if(list1.get(ind1) < list2.get(ind2)){
                ind1++;
            }else{
                ind2++;
            }
        }

        System.out.println(dist);

    }
}
