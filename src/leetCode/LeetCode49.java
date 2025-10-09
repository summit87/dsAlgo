package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode49 {
public static void main(String[] args) {
    String[] strs = {""};
    System.out.println(groupAnagrams(strs));
}

 public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,String> map =  new HashMap<>();
        List<Anagram> list = new ArrayList<>();
        for(int ind = 0;ind < strs.length;ind++){
            map.put(ind,strs[ind]);
            int[] count = new int[26];
            for(int cnt = 0;cnt<strs[ind].length();cnt++){
                count[strs[ind].charAt(cnt) - 'a'] ++;
            }

            StringBuilder sb = new StringBuilder();
            for(int cnt=0;cnt < count.length;cnt++){
                sb=sb.append(""+count[cnt]).append("#");
            }
            String sb1 = sb.toString();
            sb1 = sb1.substring(0,sb1.lastIndexOf("#"));
            Anagram ang = new Anagram();
            ang.val = sb1;
            ang.index=ind;
            list.add(ang);
        }

        Map<Object,List<Anagram>> map1 =  list.stream()
                     .collect(Collectors.groupingBy(a -> a.val,Collectors.toList()));

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Object,List<Anagram>> m : map1.entrySet()){
            List<String> sts = new ArrayList<>();
            for(Anagram a : m.getValue()){
                sts.add(map.get(a.index));
            }
            res.add(sts);
        }
       
        return res;
    }
}

class Anagram{
    String val;
    int index;
}
