package leetCode;

import java.util.*;
import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 * 
 * One catch in this problem is to undertand the top k most frequent element
 * e.k if k = 2, then
 * if in an array the total element we have 2 (may be unique or repeated) , then that is also called top k frequent element or
 * if in an array the total element we have 6, (some of the unique, not all the element are unique ) , 
 *          
 * 
 */

public class LeetCode347 {

    public static void main(String[] args) {
        int[] a = {1,3,4,4,6,6,8};int k = 2;
        for(int x : topKUsingMap(a, k)){
            System.out.print(x+" ,");
        }

        topkKElementUsingQuickSelect(a,k);
       
    }

    /**
     * First approach
     * The idea is to create a map and count the frequency of each element in array
     * then sort the map by value decending order, 
     * then create an array obeject of the len k and get top k element from map and store in that array and return
     * 
     * second approach , 
     * create an array of size(max-min+1) , why : we will end up with size of the array equal to number of unique element
     * and boolean array with same size and priorty queue (should be sorted in acending order)
     * 
     */


     public static int[] topKFrequent(int[] nums,int k){
       

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(min > nums[i]){
                min = nums[i];
            }

            if(max < nums[i]){
                max = nums[i];
            }
        }

        int[] count = new int[max - min + 1];
        final int min1 = min;
        boolean[] visited = new boolean[max-min+1];

        /**
         * This is good technique , 
         * 
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(extracted1(count, min1));

        for(int x : nums){
            count[x-min]++;
        }

        for(int num : nums){
            if(visited[num - min]){
                continue;
            }
            visited[num - min] = true;
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        for(int i=0;i < k;i++){
            res[i] = pq.poll();
        }


        return res;
     }

    private static Comparator<? super Integer> extracted1(int[] count, final int min1) {
        return (a,b) -> Integer.compare(count[a-min1],count[b-min1]);
    }





    public static int[] topKUsingMap(int[] a,int k){
        int[] val = new int[k];

        Map<Integer,Integer> map = new HashMap<>();
        for(int n : a){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> (map.get(n1) - map.get(n2)));
        Set<Integer> set = new HashSet<>();
        for(int n : map.keySet()){
            if (set.contains(n)) {
                continue;
            }
            set.add(n);
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
            
        }
        val = new int[pq.size()];
        int l = 0;
        while(!pq.isEmpty()){
            val[l++] = pq.poll();
        }
        return val;
    }


    public static int[] topkKElementUsingQuickSelect(int[] a,int k){

        /**
         * 1. First traverse the array and count occurence of the element
         * 2. create another array which will store the unique array element
         * 3. since we know , we need to find the top k element , 
         *     what if we can find the kth larest element by count value using quick select
         * 4. then copy the value from unique array from range n to n-k and return the value;
         * 
         *  */        


         Map<Integer,Integer> map = new HashMap<>();
         for(int i=0;i<a.length;i++){
            map.put(a[i], map.getOrDefault(a[i], 0)+1);
         }

        int[] uniqe = new int[map.size()];
        int x=0;
         for(Map.Entry<Integer,Integer> m : map.entrySet()){
            uniqe[x] = m.getKey();
            x++;
         }

         quickSelect(uniqe, map, 0, uniqe.length-1, uniqe.length-k);
         System.out.println();
         for(int i=uniqe.length-k;i<uniqe.length;i++){
            System.out.print(uniqe[i]+",");
         }



        return null;
    }


    private static void quickSelect(int[] a,Map<Integer,Integer> map,int left,int right,int kth){
        if(left > right){
            return;
        }
        Random random =  new Random();
        int p = left+random.nextInt((right - left));
        int pivotIndex = quickSelectPartinion(a, map, left, right,p);
        if(kth == pivotIndex){
            return;
        }

        if(kth < pivotIndex){
            quickSelect(a, map, left, pivotIndex-1, kth);
            
        }else {
            quickSelect(a, map, pivotIndex+1, right, kth);
            
        }

    }


    private static int quickSelectPartinion(int[] a,Map<Integer,Integer> map,int left,int right,int pi){
        int mid = (left+(right-left)/2);
        int p = map.get(a[pi]);
        int i=left-1;
        int j = left;
        while(j <= right){
            if(p >= map.get(a[j])){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            j++;
        }
        
        int temp = a[i+1];
            a[i+1] = p;
            a[right] = temp;
        return i+1;
        
    }

}
