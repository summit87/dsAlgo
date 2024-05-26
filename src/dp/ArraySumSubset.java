package dp;

import java.util.ArrayList;
import java.util.List;

public class ArraySumSubset {

    public static void main(String[] args) {
        int sum = 24;
        int[] a = {12, 1, 61, 5, 9, 2};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        subSet(a, sum, list, l, 0);
        for(List<Integer> l1 : list){
            //l1.forEach(System.out::println);
        }
    }

    private static void subSet(int[] a, int sum, List<List<Integer>> list, List<Integer> l, int index) {

        if (sum == 0) {
            l.forEach(System.out::println);
            list.add(l);
            return;
        }
        for (int i = index; i < a.length; i++) {
            l.add(a[i]);
            sum = sum - a[i];
            subSet(a, sum, list, l, i + 1);
            int x = l.remove(l.size() - 1);
            sum = sum + x;
        }
    }
}
