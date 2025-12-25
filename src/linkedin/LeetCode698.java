package linkedin;

import java.util.HashSet;
import java.util.Set;

/**
 * Partition k equal subset
 */
public class LeetCode698 {
    public static void main(String[] args) {
        int[] a = {4,3,2,3,5,2,1};
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int s : a){
            sum+= s;
        }
        int k = 4;
        if(sum %k != 0){
            System.out.println("Can't be devide to k partition");
            return;
        }
        int requiredSum = sum / k;
        int count=0;
        System.out.println(isPartition(a, 0, requiredSum, 0, set, k,count));
    }

    public static  boolean isPartition(int[] a,int index,int requiredSum,int currentSum,Set<Integer> taken,int k,int count){

         if(count == k){
            return true;
        }
        // base condition
        if(currentSum == requiredSum){
            /**
             * If sum is completed for one bucket, then i am considering to start from 0,
             * since there may be some element which we skip during the calculation , so include those element , w
             * we are starting from zero
             */
            return  isPartition(a, 0, requiredSum, 0, taken, k,count+1);
        }

        if(taken.contains(index)){
            return isPartition(a, index+1, requiredSum, currentSum, taken, k, count);
        }
        
        if(index >= a.length){
            return false;
        }
        if(currentSum > requiredSum){
            return false;
        }
        currentSum += a[index];
        taken.add(index);
        boolean op1 = isPartition(a, index+1, requiredSum, currentSum, taken, k,count);

        currentSum -= a[index];
        taken.remove(index);
        boolean op2 = isPartition(a, index+1, requiredSum, currentSum, taken, k,count);
        return op1 || op2;
    }


}
