package leetCode;

/**
 * Maximum Difference Between Increasing Elements
 */
public class LeetCode2016 {
    public static void main(String[] args) {
        int[] a = {7,1,5,4,12,8};
        int ele = a[0];
        int maxDiff = Integer.MIN_VALUE;
        int st = 0;
        int end = 0;
        for(int i=1;i<a.length;i++){
            if(ele < a[i]){
                if(maxDiff < a[i] - ele){
                maxDiff = a[i] - ele;
                end = i;
                }
            }else{
                st = i;
                ele = a[i];
            }
        }

        System.out.println(st+" : "+end);
    }
}
