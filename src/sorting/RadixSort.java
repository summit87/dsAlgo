package sorting;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class RadixSort {
    public static void main(String[] args) {
        int[] a = {237,146,259,348,152,163,235,48,36,62,1000};
        for(int x : radix(a)){
            System.out.print(x+",");
        }
    }

    public static int[] radix(int[] a){
        int[] res = new int[a.length];
        int max = Integer.MIN_VALUE;
        for(int x : a){
            max = Math.max(x, max);
        }
        int i = 0;

        while(true){
            if(Math.pow(10,i) > max){
                break;
            }

            res = new int[a.length];
            TreeMap<Integer,Queue<Integer>> m1 = new TreeMap<>();
            int temp = (int) Math.pow(10, i);
            for(int x = 0;x < a.length;x++){
                int index = (a[x]/temp) % 10;
                m1.putIfAbsent(index, new LinkedList<>());
                m1.get(index).offer(a[x]);
            }

            int tempIndex = 0;
            for(Map.Entry<Integer,Queue<Integer>> m2 : m1.entrySet()){
                Queue<Integer> q = m2.getValue();
                while(!q.isEmpty()){
                    res[tempIndex] = q.poll();
                    tempIndex++;
                }
            }
            a = res;
            i++;
        }
        return res;
    }
}
