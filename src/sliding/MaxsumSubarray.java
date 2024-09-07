package array.slidingWindow;

public class MaxsumSubarray {

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        
        maxSum(a);
    }

    private static void maxSum(int[] a) {
        int finalMaxSum = Integer.MIN_VALUE;
        int currentSum = a[0];
        int st = 0;
        int end = 0;
        for(int i=1;i<a.length;i++){
            currentSum = currentSum+a[i];
            if(currentSum < a[i]){
                currentSum = a[i];
                st = i;
            }
            if(finalMaxSum < currentSum){
                finalMaxSum = currentSum;
                end = i;
            }
        }

        System.out.println(finalMaxSum+" > startIndex : "+st+"  endIndex: "+end);
    }
}
