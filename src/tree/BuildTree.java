package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import list.MList;

public class BuildTree {

    private static MList<Integer> headRef;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("list1.txt"));
        MList<Integer> mlist = new MList<Integer>();
        MList<Integer> mlist1 = null;
        while (scanner.hasNext()) {
            Integer v = scanner.nextInt();
            mlist1 = mlist.createList(v, mlist1);
        }
        MList<Integer> head = mlist1;
        MList<Integer> tail = mlist1;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        // TreeNode tn = buildNode(head,tail);
        // tn.printTreeInOrder(tn);
        int start = 0;
        int end =0;
        headRef = mlist1;
        while (head != null) {
            end++;
            head = head.getNext();
        }

        TreeNode tree = createTree(start,end);
        tree.printTreeInOrder(tree);
    }

    public static TreeNode buildNode(MList<Integer> head, MList<Integer> tail) {
        if (head == null || tail == null) {
            return null;
        }

        TreeNode tn = new TreeNode();
        if (head.getData().equals(tail.getData())) {
            tn.setData(head.getData());
            return tn;
        }
        MList<Integer> slow = head;
        MList<Integer> fast = head;
        MList<Integer> prev = head;
        while (slow != null && fast != null && fast != tail && fast.getNext() != null) {
            prev = slow;
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast != tail && fast.getNext() != null) {
                fast = fast.getNext();
            }
        }

        tn.setLeft(buildNode(head, prev));
        tn.setRight(buildNode(slow, fast));

        return tn;
    }

    public static TreeNode createTree(int start,int end) {
        if (start > end || start < 0 ) {
            return null;
        }
        if(start == end){
            return null;
        }
        int mid = start + ((end-start)/2);
        TreeNode left = createTree(start,mid);
        TreeNode tn = new TreeNode(headRef.getData());
        headRef = headRef.getNext();
        tn.setLeft(left);
        tn.setRight(createTree(mid+1,end));
        return tn;
    }
}
