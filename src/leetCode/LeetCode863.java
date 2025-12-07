package leetCode;

import java.util.*;

/**
 * Find all the node at distance k from given target
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM
 * <p>
 * Approach 1: DFS approach
 * 1. parent pointer is given in the tree ,  then
 * connect all the node to there parent , after that , store the parent of each node to map
 * once above step is done,then do the dfs which include traversal  for parent,left and right child
 * Approach 2 :
 * 1.Instead of using parent pointer ,we can use map to store the mapping of parent and chile item and then do the dfs
 */
public class LeetCode863 {
    public static void main(String[] args) {
        approach2();
    }


    public static void approach2() {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        TreeNode tn = TreeNode.createTree();
        connectParentUsingMap(tn, map);
        Set<Integer> set = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        dfs2(tn.left, 2, order, set, map);
        System.out.println(order);
    }

    private static void connectParentUsingMap(TreeNode tn, Map<Integer, List<TreeNode>> map) {
        if (tn == null) {
            return;
        }
        if (tn.left != null) {
            map.computeIfAbsent(tn.val, k -> new ArrayList<>()).add(tn.left);
            map.computeIfAbsent(tn.left.val, k -> new ArrayList<>()).add(tn);
        }

        if (tn.right != null) {
            map.computeIfAbsent(tn.val, k -> new ArrayList<>()).add(tn.right);
            map.computeIfAbsent(tn.right.val, k -> new ArrayList<>()).add(tn);
        }

        connectParentUsingMap(tn.left, map);
        connectParentUsingMap(tn.right, map);
    }


    private static void dfs2(TreeNode target, int l, List<Integer> list, Set<Integer> set, Map<Integer, List<TreeNode>> map) {
        if (target == null || set.contains(target.val)) {
            return;
        }

        if (l == 0) {
            list.add(target.val);
            return;
        }
        set.add(target.val);
        List<TreeNode> nodes = map.get(target.val);
        for (TreeNode tn1 : nodes) {
            if (!set.contains(tn1.val)) {
                dfs2(tn1, l - 1, list, set, map);
            }
        }
    }


    static void approach1() {
        TreeNodeWithParentPointer treeNodeWithParentPointer = TreeNodeWithParentPointer.createTree();
        connectWithParent(treeNodeWithParentPointer, null);
        printAlltheParentNode(treeNodeWithParentPointer);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        /*
         * for above example target item number is 5
         */
        dfs(treeNodeWithParentPointer.left, 2, set, list);
        System.out.println(list);
    }

    public static void connectWithParent(TreeNodeWithParentPointer tree, TreeNodeWithParentPointer parent) {
        if (tree == null) {
            return;
        }
        tree.parent = parent;
        connectWithParent(tree.left, tree);
        connectWithParent(tree.right, tree);
    }

    static void printAlltheParentNode(TreeNodeWithParentPointer node) {
        if (node == null) {
            return;
        }

        System.out.println("Parent of node [ " + node.val + " ] is -> " + (node.parent == null ? "" : node.parent.val));
        printAlltheParentNode(node.left);
        printAlltheParentNode(node.right);
    }


    public static void dfs(TreeNodeWithParentPointer tree, int k, Set<Integer> set, List<Integer> order) {
        if (tree == null || set.contains(tree.val)) {
            return;
        }

        if (k == 0) {
            order.add(tree.val);
            return;
        }
        /**
         * Since we are passing target item directly in method,
         * we don't have to put check for this
         */
        set.add(tree.val);
        dfs(tree.parent, k - 1, set, order);
        dfs(tree.left, k - 1, set, order);
        dfs(tree.right, k - 1, set, order);
    }


}

class TreeNodeWithParentPointer {
    TreeNodeWithParentPointer parent;
    TreeNodeWithParentPointer left;
    TreeNodeWithParentPointer right;
    int val;


    public TreeNodeWithParentPointer(int val) {
        this.val = val;
        this.parent = null;
        this.left = null;
        this.right = null;
    }


    public static TreeNodeWithParentPointer createTree() {
        TreeNodeWithParentPointer tree = new TreeNodeWithParentPointer(3);
        tree.left = new TreeNodeWithParentPointer(5);
        tree.right = new TreeNodeWithParentPointer(1);
        tree.left.left = new TreeNodeWithParentPointer(6);
        tree.left.right = new TreeNodeWithParentPointer(2);
        tree.left.right.left = new TreeNodeWithParentPointer(7);
        tree.left.right.right = new TreeNodeWithParentPointer(4);
        tree.right.left = new TreeNodeWithParentPointer(0);
        tree.right.right = new TreeNodeWithParentPointer(8);
        return tree;
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;


    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }


    public static TreeNode createTree() {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(1);
        tree.left.left = new TreeNode(6);
        tree.left.right = new TreeNode(2);
        tree.left.right.left = new TreeNode(7);
        tree.left.right.right = new TreeNode(4);
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(8);
        return tree;
    }

    public static TreeNode createNode1(){
        TreeNode tn1 = new TreeNode(1);
        tn1.left = new TreeNode(2);
        tn1.left.left = null;
        tn1.left.right = null;
        tn1.right = new TreeNode(3);
        tn1.right.left = new TreeNode(4);
        tn1.right.left.left = null;
        tn1.right.left.right = null;
        tn1.right.right = new TreeNode(5);
        tn1.right.right.left = null;
        tn1.right.right.right = null;
        return tn1;
    }

     public static TreeNode createNode2(){
        TreeNode tn1 = new TreeNode(4);
        tn1.left = new TreeNode(2);
        tn1.right = new TreeNode(5);
        tn1.left.left = new TreeNode(1);
        tn1.left.right = new TreeNode(3);
        return tn1;
    }
}


