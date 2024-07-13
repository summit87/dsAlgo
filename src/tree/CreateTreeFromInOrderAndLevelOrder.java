package tree;

public class CreateTreeFromInOrderAndLevelOrder {

    public static void main(String[] args) {
        int[] inOrder = {4, 8, 10, 12, 14, 20, 22}; ;
        int[] level =  {20, 8, 22, 4, 12, 10, 14};
        TreeNode tn = createTree(level, inOrder, 0, inOrder.length-1);
        tn.printTreeInOrder(tn);
    }

    private static TreeNode createTree(int[] level, int[] inOrder, int st, int end) {
        if (st > end) {
            return null;
        }

        if (st == end) {
            return new TreeNode(inOrder[st]);
        }

        boolean flag = false;
        int ind = st;
        for (int i = 0; i < level.length; i++) {
            flag = false;
            for (int j = st; j < end; j++) {
                if (level[i] == inOrder[j]) {
                    flag = true;
                    ind = j;
                    break;
                }
            }
            if (flag == true) {
                break;
            }
        }
        if(flag == false){
            return null;
        }

        TreeNode tn = new TreeNode(inOrder[ind]);

        tn.setLeft(createTree(level, inOrder, st, ind-1));
        tn.setRight(createTree(level, inOrder, ind+1 , end));
        return tn;
    }
}
