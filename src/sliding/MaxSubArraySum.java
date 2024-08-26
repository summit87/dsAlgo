package sliding;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] a = {100,200,300,400};
        int k = 2;
        System.out.println(maxSubArraySum1(a, k));
    }

    private static int maxSubArraySum(int[] a, int size) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int sum = a[i];
            int k = size;
            for (int j = i + 1; j < a.length && k > 1; j++, k--) {
                sum += a[j];
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    private static int maxSubArraySum1(int[] a, int size) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<size;i++){
            sum+=a[i];
        }

        for(int i=size;i<=a.length-size+1;i++){
            sum+=a[i]-a[i-size];
            if(maxSum < sum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

}
