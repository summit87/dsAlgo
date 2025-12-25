package linkedin;

public class MaxSubArrayWithKConcatenation {
    public static void main(String[] args) {
        int[] a = {1,-2,3,-2};
        int k=1;
        System.out.println(maxSum(a, k));
    }

    public static int maxSum(int[] a,int k){
        int max = a[0];
        int maxTillNow = a[0];
        for(int i = 0;i <a.length*k;i++){
            maxTillNow+= a[i%a.length];
            if(maxTillNow < a[i%a.length]){
                maxTillNow = a[i%a.length];
            }
            max = Math.max(max, maxTillNow);
        }
        return max;
    }
}
