package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode297 {
    public static void main(String[] args) {
        TreeNode tn = TreeNode.createNode1();
        print(tn);
        System.out.println();
        String[] data = serilaize(tn).split(",");
        
        print(deserialize(data));

    }

    public static String serilaize(TreeNode tn){
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(tn);
        while(!queue.isEmpty()){
            TreeNode tn1 = queue.poll();
            sb.append(tn1.val+",");
            if(tn1.left != null){
                queue.add(tn1.left);
            }else{
                sb.append("$,");
            }

            if(tn1.right != null){
                queue.add(tn1.right);
            }else{
                sb.append("$,");
            }
        }
        return sb.toString();
    }

    public static  TreeNode deserialize(String[] data){
        TreeNode tn = new TreeNode(Integer.valueOf(data[0]).intValue());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tn);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode tn1 = queue.poll();
            
            if(i < data.length && !data[i].equals("$")){
                TreeNode tn2 = new TreeNode(Integer.valueOf(data[i]).intValue());
                tn1.left = tn2;
                queue.add(tn2);
            }
            i++;
            if(i < data.length && !data[i].equals("$")){
                TreeNode tn2 = new TreeNode(Integer.valueOf(data[i]).intValue());
                tn1.right = tn2;
                queue.add(tn2);
            }
            i++;
        }
        return tn;
    }

    public static  void print(TreeNode tn){
        if(tn == null) return;
        print(tn.left);
        System.out.print(tn.val+" : ");
        print(tn.right);
    }


}
