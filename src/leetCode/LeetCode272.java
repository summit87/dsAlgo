package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode272 {
    public static void main(String[] args) {

        double target = 3.714286;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                (a, b) -> Math.abs(a - target) - Math.abs(b - target) > 0 ? -1 : 1);
        inOrder(TreeNode.createNode2(), target, pq, 2);
        List<Integer> list = new ArrayList<>(2);
        int i = 2;
        while (!pq.isEmpty() && i > 0) {
            list.add(pq.poll());
            i--;
        }
        list.sort((a,b) -> b-a);
        list.forEach(System.out::println);


    }

    private static void inOrder(TreeNode tn, double targetNode, PriorityQueue<Integer> pq, int k) {
        if (tn == null) {
            return;
        }
        inOrder(tn.left, targetNode, pq, k);
        if (pq.size() < k) {
            pq.add(tn.val);
        } else {
            if (Math.abs(pq.peek() - targetNode) >= Math.abs(tn.val - targetNode)) {

                int x = pq.poll();
                if (Math.abs(x - targetNode) == Math.abs(tn.val - targetNode)) {
                    if (x < tn.val) {
                        pq.add(x);
                    }
                } else {
                    pq.add(tn.val);
                }
            }
        }
        inOrder(tn.right, targetNode, pq, k);
    }
}
