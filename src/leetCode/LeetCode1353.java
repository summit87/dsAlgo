package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * The problem say's we can attend the maximum meeting , but it's not necessary
 * i should stay in meeting till end of endDay
 * i may or may not be staying in meeting, e.g
 * start and End day of the meeting as given below
 * {[1,1],[1,3],[2,3]} ,
 * so here first meeting start at day one and end at day 1
 * second meeting start at day one and end at day 3
 * third meeting start at day 2 and end at day 3rd
 * 
 * so in day one i can attend two meeting (Remember i may or may not be staying
 * in meetng till end) [1,1] and [1,3]
 * in day send i can attend meeting [2,3]
 * 
 * so total max meeting is 3
 */
public class LeetCode1353 {
    public static void main(String[] args) {
        int[][] a = { { 1, 2 }, { 1, 2 }, { 1, 6 }, { 1, 2 }, { 1, 2 } };
        // int[][] a = {{1,10},{1,10},{1,10},{1,10}};
        System.out.println(maxMeeting1(a));
    }

    public static int maxMeeting(int[][] a) {
        int res = 0;
        int maxDay = Integer.MIN_VALUE;
        for (int[] a1 : a) {
            maxDay = Math.max(maxDay, a1[1]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        Arrays.sort(a, (a1, a2) -> {
            if (a1[1] < a2[1]) {
                return a2[0] - a1[0];
            }
            return a1[0] - a2[0];
        });
        for (int day = 1; day <= maxDay; day++) {
            /**
             * Will add all those event which we need to attend on that day "day"
             */
            while (index < a.length && a[index][0] <= day) {
                pq.add(a[index][1]);
                index++;
            }
            /**
             * Will remove those event which we attended in prevous day
             */
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }

        }
        return res;
    }

    public static int maxMeeting1(int[][] a) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        Arrays.sort(a, (a1, a2) -> {
            if (a1[1] < a2[1]) {
                return a2[0] - a1[0];
            }
            return a1[0] - a2[0];
        });
        pq.add(a[0][1]);
        int day = 1;
        while (!pq.isEmpty()) {
            /**
             * Will add all those event which we need to attend on that day "day"
             */

            if (pq.isEmpty()) {
                pq.add(a[index][1]);
                day = a[index][1];
                index++;
            }

            while (index < a.length && a[index][0] <= day) {
                pq.add(a[index][1]);
                index++;
            }
            /**
             * Will remove those event which we attended in prevous day
             */
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            day++;

        }
        return res;
    }
}
