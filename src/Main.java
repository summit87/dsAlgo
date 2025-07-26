// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;

public class Main {
    public static void main(String[] args) {
       Map<String,String> map = new HashMap<String,String>();
       map.put("hot", "hit");
       map.put("lot","hot");
       map.put("log","lot");
       map.put("cog","log");
       List<String> list = new ArrayList<>();
       print(map, "hit", "cog","hit",list);
       System.out.println(list);
       List<List<Integer>> l = new ArrayList<>();
      double f =  Double.MAX_VALUE;

      SortedMap<Integer,String> treeMap = new TreeMap<>();
      treeMap.put(1, "12");
      treeMap.put(8, "123");
     System.out.println(treeMap.containsKey(3));

       
       

    }

    public static void print(Map<String,String> map,String begin,String end,String s,List<String> list){
        if(map.containsKey(begin) && map.get(begin).equals(s)){
           list.add(map.get(begin));
           
            return;
        }
        list.add(map.get(end));
        print(map, map.get(end), map.get(end),s,list);
    } 
}