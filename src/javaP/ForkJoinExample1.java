package javaP;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


/**
 * IN this example we will sum array value using two thread
 */
public class ForkJoinExample1 {
    public static void main(String[] args) {
        int len = 11111111;
        Long[] array = new Long[len];
        for(int i =0;i<len;i++){
            array[i] = Long.valueOf(i);
        }
       ForkJoinPool forkJoinPool = new ForkJoinPool(2);
       Long res = forkJoinPool.invoke(new SumTask(array, 0, len-1));
       System.out.println(res);
       System.out.println(result(array));

    }

    private static long result(Long[] array){
        long sum = 0l;
        for(int i =0;i<array.length;i++){
            sum+=array[i];
        }
        return sum;
    }
}

class SumTask extends RecursiveTask<Long>{
    Long[] array;
    int left;
    int right;

    public SumTask(Long[] array,int left,int right) {
        this.left = left;
        this.right = right;
        this.array = array;
    }

    @Override
    protected Long compute() {
       if(right-left <= 10){
        Long sum = 0l;
        for(int ind = left;ind <= right;ind++){
            sum+=array[ind];
        }
        return sum;
       }
       int mid = (left+right)/2;
     
       SumTask leftSumTask = new SumTask(array,left,mid);
       SumTask righSumTask = new SumTask(array, mid+1, right);
       leftSumTask.fork();
       righSumTask.fork();
       Long rightSum = righSumTask.join();
       Long leftSum = leftSumTask.join();
       return leftSum+rightSum;
    }

    

    

}
