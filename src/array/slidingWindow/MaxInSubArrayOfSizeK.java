package array.slidingWindow;

import java.util.*;

import dp.LIS;

public class MaxInSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // maxInSubArray(a, 4);
        maxElementInKWindow(a, 3);
        System.out.println();
        maxInSubArrayOfSizeK(a, 3);
    }

    private static void maxInSubArray(int[] a, int k) {
        PriorityQueue<Pair1> p = new PriorityQueue<Pair1>((a1, b1) -> b1.b - a1.b);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Pair1 p1 = new Pair1();
            p1.a = i;
            p1.b = a[i];
            p.add(p1);
        }
        list.add(p.peek().b);

        for (int i = k; i < a.length; i++) {
            Pair1 p1 = new Pair1();
            p1.a = i;
            p1.b = a[i];
            p.offer(p1);
            while (p.peek().a <= i - k) {
                p.poll();
            }
            list.add(p.peek().b);
        }

        for (int i : list) {
            System.out.println(i);
        }

    }

    /**
     * Using dequeue
     * TC : O(2N), actually every element will be touched by atmost two times,
     * so final TC will be O(2N) => O(N)
     * 
     * @param a
     * @param k
     */
    private static void maxElementInKWindow(int[] a, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && a[i] >= a[deque.peekFirst()]) {
                deque.pollFirst();
            }
            deque.addLast(i);
        }
        for (int i = k; i < a.length; i++) {
            System.out.print(a[deque.peekFirst()] + ",");

            while (!deque.isEmpty() && deque.peekLast() <= (i - k)) {
                deque.pollLast();
            }

            while (!deque.isEmpty() && a[deque.peekFirst()] <= a[i]) {
                deque.pollFirst();
            }
            deque.addLast(i);
        }
        System.out.print(a[deque.peek()]);

    }

    /**
     * This algo we are using here based on two pointer approach
     * TC : Will be O(N*K) ,
     *
     * @param a
     * @param k
     */
    private static void maxInSubArrayOfSizeK(int[] a, int k) {
        if (k == 1) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + ",");
            }
            return;
        }
        int start = 0;
        int end = k - 1;
        /**
         * slideStart will be used to slide the left window to one position
         */
        int slideStart = 0;
        int max = a[k - 1];
        while (end < a.length) {
            if (a[start] > max) {
                max = a[start];
            }
            start++;
            if (end == start && start < a.length) {
                System.out.print(max + ",");
                end++;
                slideStart++;
                start = slideStart;
                /**
                 * Once we print first max element we need to reassing / initialize the max
                 * value
                 */
                if (end < a.length) {
                    max = a[end];
                }
            }
        }
    }
}

class Pair1 {
    public int a;
    public int b;
}
