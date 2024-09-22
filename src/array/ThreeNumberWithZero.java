package array;

import java.util.*;

import dp.LIS;;

/**
 * [0, -1, 1], [2, -3, 1]
 */
public class ThreeNumberWithZero {
    public static void main(String[] args) {
        int[] a = { 0, -1, 2, -3, 1 };
        threeNumber(a);
        System.out.println();
        threeNumberUsingSorting(a);

    }

    /*
     * Findindg the target sum zero from three number , we can follow following
     * approach
     * 1. We can do in O(N3) , with three nestead loop
     * 2. We can do in O(N2) and
     * 1. space O(N) , space will be used by hashMap
     * 2. We can first sort the array and do in O(N2) and space tc is 1
     */
    /**
     * The basic rule a + b + c = 0
     * c = -a - b
     * Here target item number will be c
     * Now we need to find two element in the array which have sum c
     * in first lop we will consider each array element as target item number
     * and in second loop we will sum with target element and check if the result
     * alreadt present into map/set
     * 
     * @param a
     */

    private static void threeNumber(int[] a) {
       
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < a.length - 1; i++) {
            int target = a[i]; // c
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < a.length; j++) {
                int sum = -target - a[j]; // -target = -a, -a[j] = -b
                if (set.contains(sum)) {
                    list.add(Arrays.asList(sum, target, a[j]));
                }
                set.add(a[j]);
            }
        }

        for (List<Integer> list2 : list) {
            System.out.print(list2);
        }
    }

    private static void threeNumberUsingSorting(int[] a){
        List<List<Integer>> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        quickSort(a, 0, a.length-1);
        for(int i=0;i<a.length;i++){
            int sum = a[i];
            l = i+1;
            r = a.length-1;
            while (l <= r) {
                int terget = -(a[l]+a[r]);
                if(sum == -(a[l]+a[r])){
                    list.add(Arrays.asList(sum,a[l],a[r]));
                    l++;
                    r--;
                }
                if(sum < terget){
                    l++;
                }else{
                    r--;
                }
            }
        }
        for (List<Integer> list2 : list) {
            System.out.print(list2);
        }
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }

        int p = findPivot(a, left, right);
        quickSort(a, left, p - 1);
        quickSort(a, p + 1, right);
    }

    private static int findPivot(int[] a,int left,int right){
        int p = a[right];
        int l = left-1;
        int j = left;
        while (j < right) {
            if(p > a[j]){
                l++;
                int temp = a[l];
                a[l] = a[j];
                a[j] = temp;
            }
            j++;
        }
        l = l+1;
        int temp = a[l];
        a[l] = a[j];
        a[j] = temp;
        return l;
    }

}
