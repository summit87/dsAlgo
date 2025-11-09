package leetCode;

import java.util.Arrays;

public class LeetCode1751 {

    /**
     * Sort the event based on the start time of the events
     * (Since we need to ignore the those event which have the overlaping inveterval
     * from picked intervals)
     * once we find the index of those , we will recursively call function
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[][] event ={{1,2,4},{3,4,3},{2,3,1}};
        Arrays.sort(event,(a,b) -> a[0] - b[0]);
        int k=2;
        System.out.println(maxValue(event, 0, k));
    }

    public static int maxValue(int[][] event, int len, int k) {
        if (len >= event.length || k <= 0) {
            return 0;
        }

        int nextInterval = getNext1(event, len+1, len);
        return Math.max(maxValue(event, len + 1, k), event[len][2] + maxValue(event, nextInterval, k--));

    }

    public static int getNext(int[][] event, int len, int pickedLen) {
        int endTime = event[pickedLen][1];
        while (len < event.length && event[len][0] <= endTime) {
            len++;
        }
        return len;
    }

    public static int getNext1(int[][] event,int len,int pickedLen){
        int endTime = event[pickedLen][1];
        int left = len;
        int right = event.length;
        while(left < right){
            int mid = left+((right-left)/2);
            if(event[mid][0]<=endTime){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return left;
    }

}
