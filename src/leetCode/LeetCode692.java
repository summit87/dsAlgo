package leetCode;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.naming.LinkException;

/**
 * https://leetcode.com/problems/top-k-frequent-words/description/
 */
public class LeetCode692 {

    public static void main(String[] args) {
        String[] st = {"i","love","leetcode","i","love","coding"};
        int k = 1;

        for (String s : topKFrequentString(st, k)) {
            System.out.print(s + ",");
        }

    }

    private static List<String> topKFrequentString(String[] strings, int k) {

        TreeMap<String, Integer> map = new TreeMap<>();
        Set<String> visitedString = new HashSet<>();

        for (String str : strings) {
            int cnt = 1;
            if (map.containsKey(str)) {
                cnt += map.get(str);
            }
            map.put(str, cnt);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                        if (a.getValue().compareTo(b.getValue()) == 0) {
                           return a.getKey().compareTo(b.getKey());
                        }
                        return a.getValue().compareTo(b.getValue());
                    }
                });
        for (Map.Entry<String, Integer> m1 : map.entrySet()) {
            if (visitedString.contains(m1.getKey())) {
                continue;
            }

            visitedString.add(m1.getKey());
            pq.add(m1);
            if (pq.size() > k) {
               System.out.println( pq.poll());
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        LinkedHashMap<String, Integer> val1 = list
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return val1.entrySet().stream().map(x -> x.getKey()).toList();
    }

}
