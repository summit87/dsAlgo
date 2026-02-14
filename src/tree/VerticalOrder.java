package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class VerticalOrder {
    public static void main(String[] args) {
        for(List<Integer> list : populate(TreeNode.createTree5())){
            System.out.println(list);
        }
    }

    private static List<List<Integer>> populate(TreeNode tn) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>((a,b) -> a-b);
        vertical(tn, map, 0,set);
        List<List<Integer>> list = new ArrayList<>();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            
            list.add(map.get(iterator.next()));
        }
        return list;
    }

    private static void vertical(TreeNode tn, Map<Integer, List<Integer>> map, int lvl, TreeSet<Integer> set) {
        if (tn == null) {
            return;
        }

        map.putIfAbsent(lvl, map.getOrDefault(lvl, new ArrayList<>()));
        map.get(lvl).add(tn.getData());
        set.add(lvl);
        vertical(tn.getLeft(), map, lvl - 1,set);
        vertical(tn.getRight(), map, lvl + 1,set);
    }
}
