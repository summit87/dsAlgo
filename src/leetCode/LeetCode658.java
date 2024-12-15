package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/?envType=problem-list-v2&envId=sliding-window
 * 
 * An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]
 */
public class LeetCode658 {
    public static void main(String[] args) {
        int[] a = {1,1,2,3,4,5};
        int k = 3;
        int x = -1;
        System.out.println(closerElement(a, k, x));
    }

    public static List<Integer> getVal(int[] a,int k,int x){
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = a.length - 1;

        while(left < right){
            int mid = left+(right-left)/2;
            if(a[mid] >= x){
                right = mid;
            }else{
                left = mid-1;
            }
        }

        

        return list;
    } 




    private static List<Integer> closerElement(int[] a,int k,int x){
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(extracted());
        for(int i=0;i<a.length;i++){
          
            if(!pq.isEmpty() && pq.size() >= k && pq.peek().diff > (int)Math.abs(x-a[i]) && pq.peek().num < a[i]){
                if(pq.size() == k){
                    pq.add(new Pair(a[i], Math.abs(x - a[i])));
                }
                pq.poll();
                
            }else if(pq.size() < k){
                pq.add(new Pair(a[i],Math.abs(x - a[i])));
            }
        }

        while(!pq.isEmpty()){
            list.add(pq.poll().num);
        }
        Collections.sort(list);
        return list;
    }


    private static Comparator<? super Pair> extracted() {
        return (p1,p2) -> p2.num!=p1.num ? p2.diff - p1.diff : p1.diff - p2.diff;
    }
}

class Pair{
    int num;
    int diff;
    public Pair(int num,int diff){
        this.num = num;
        this.diff = diff;
    }
}
