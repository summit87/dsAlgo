package linkedin;

public class LeetCode53 {
    public static void main(String[] args) {
        int[] a = {2, 3, -8, 7, -1, 2, };
        System.out.println(maxSum(a));
        maxSum1(a);
    }

    public static int maxSum(int[] a){
        int maxTillNow = a[0];
        int max = a[0];
        for(int i=1;i < a.length;i++){
            maxTillNow+=a[i];
            maxTillNow = Math.max(maxTillNow, a[i]);
            max = Math.max(max, maxTillNow);
        }
        return max;
    }

    public static void maxSum1(int[] a){
        int st = 0;
        int end = 0;
        int maxTillNow = a[0];
        int max = a[0];

        for(int i=1;i < a.length;i++){
            maxTillNow+=a[i];
            if(maxTillNow < a[i]){
                maxTillNow = a[i];
            }
            if(max < maxTillNow){
                st = end;
                end = i;
                max = maxTillNow;
            }
        }

        System.out.println(st+" : "+end);
    }
}
