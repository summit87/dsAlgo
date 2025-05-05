package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode315 {
    public static void main(String[] args) {
        int offset = 10000;
        int size = 2*offset+1;
        int[] tree = new int[2*size];
        int[] nums = {5,2,6,1};
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length-1;i>=0;i--){
            int val = createIndex(tree, 0+offset, nums[i]+offset,0);
            System.out.print(val+",");

            update(tree, nums[i]+offset, 0, tree.length-1, 1,size);
        }
    }

    public static int createIndex(int[] array,int leftIndex,int rightIndex,int index){
        if(leftIndex == rightIndex){
            return array[leftIndex];
        }
        int mid = (leftIndex+rightIndex) >> 1;
        int res = 0;
        array[index] = createIndex(array, leftIndex, mid,2*index+1)+createIndex(array,mid+1,rightIndex,2*index+2);
        return array[index];
    }


    public static void update(int[] array,int index,int left,int right,int delta,int size){
       index+=size;
       array[index]+=delta;
       while(index >1){
        index/=2;
        array[index] = array[2*index]+array[2*index+1];
       }
    }
}
