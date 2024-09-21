package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;;

public class KthElementInStreamOfData {
    public static void main(String[] args) {
        int[] a = {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;

        int[] a1 = {2, 5, 1, 7, 9}; int k1 = 2;
        kthElement(a, k);
    }

    /**
     * Input: stream[] = {10, 20, 11, 70, 50, 40, 100, 5, . . .}, K = 3
Output: {_,   _, 10, 11, 20, 40, 50,  50, . . .}
/**
 * 10 ,11,20,40,50,50....
 */

    private static void kthElement(int[] a,int k){
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<a.length;i++){
            if(pq.size() < k){
                pq.add(a[i]);
                System.out.println("Adding "+a[i]);
            }else {
                if(a[i] > pq.peek()){
                    int val2 = pq.peek();
                    int val = pq.poll();
                    System.out.println("Pool : "+val+" : "+val2);
                    
                    pq.add(a[i]);
                    //list.add(a[i]);
                }
            }

            if(pq.size() >= k){
                list.add(pq.peek());
                //pq.add(a[i]);
            }
            
        }

        list.forEach((x) -> System.out.print(x+","));
    }

}



