package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree will be BST, its just that we need to find , the given array is level order traversal or not
 */

/**
 *        7        
       /    \       
      4     12      
     / \    /     
    3   6  8    
   /   /    \
  1   5     10

 */
public class IsArrayLevelOrderTraversalOfBST {
    public static void main(String[] args) {
        int[] a= {7, 4, 12, 3, 6, 8, 1, 5, 10};// this is level order traversal , this should return true
        int[] a1= {7,4,3,6,12,8}; // pre-order traversal , it will return false;
        System.out.println(isLevelOrderTraversal(a1));
    }

    public static boolean isLevelOrderTraversal(int[] a){
        Queue<NodeVal> queue = new LinkedList<>();
        NodeVal nodeVal = new NodeVal(a[0]);
        nodeVal.setMax(Integer.MAX_VALUE);
        nodeVal.setMin(Integer.MIN_VALUE);
        queue.add(nodeVal);
        int i =1;
        while(i <a.length && !queue.isEmpty()){
            NodeVal temp = queue.poll();
            if(a[i]  < temp.getData() && a[i] > temp.getMin()){
                NodeVal node = new NodeVal(a[i]);
                node.setMax(temp.getData());
                node.setMin(temp.getMin());
                queue.add(node);
                i = i+1;
            }

            if(a[i] > temp.getData() && a[i] < temp.getMax()){
                NodeVal node = new NodeVal(a[i]);
                node.setMin(temp.getData());
                node.setMax(temp.getMax());
                queue.add(node);
                i++;
            }

            if( i == a.length){
                return true;
            }
        }
        return false;
    }
}

class NodeVal{
    private int data;
    private int MIN_VALUE;
    private int MAX_VALUE;

    public NodeVal(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public int getMin(){
        return this.MIN_VALUE;
    }

    public int getMax(){
        return this.MAX_VALUE;
    }

    public void setMin(int min){
        this.MIN_VALUE = min;
    }

    public void setMax(int max){
        this.MAX_VALUE = max;
    }

    public void setData(int data){
        this.data = data;
    }
}


