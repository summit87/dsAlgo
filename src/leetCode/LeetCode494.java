package leetCode;

public class LeetCode494 {
    static int count=0;
    public static void main(String[] args) {
        int[] a = {1,1,1,1,1};
        int target = 3;
        countOfExpressoin(a, 0,  target, 0);
        System.out.println(count);
    }


    public static void countOfExpressoin(int[] a,int index,int target,int sum){
        if(index >= a.length){
            if(index == a.length && sum == target){
                count++;
            }
            return;
        }
        countOfExpressoin(a, index+1,  target, sum+a[index]);
        countOfExpressoin(a, index+1,  target, sum-a[index]);
    }

    
}
