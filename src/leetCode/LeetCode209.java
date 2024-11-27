package leetCode;

/**
 * Smallest sub array 
 * captal gain stock L: 1st 23 - 31 st march
 * wazirx 
 */
public class LeetCode209 {
    public static void main(String[] args) {
        int[] a = {1, 4, 45, 6, 0, 19};
        int sum = 51;
        //System.out.println(smallestSubArray(a, sum));
        System.out.println(minLen(a, sum));
    }


    private static int smallestSubArray(int[] a,int sum){
        int minLen = Integer.MAX_VALUE;

        for(int i = 0;i<a.length-1;i++){
            int val = a[i];
            int j = i+1;
            for(;j<a.length;j++){
                val+=a[j];
                if (val > sum) {
                    break;
                }
            }

            if(minLen > (j-i+1)){
                minLen = (j-i+1);
            }
        }
        return minLen;
    }

    private static int minLen(int[] a,int sum){
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int val = 0;
        while( end < a.length){
            while( val <= sum && end < a.length){
                val+=a[end];
                end++;
            }

            while(val >= sum && start < a.length){
                if(minLen > (end-start+1)){
                    minLen = (end - start + 1);
                }
                val -=a[start];
                start++;
            }

            

            
        }
        return minLen;

    }




    

}
