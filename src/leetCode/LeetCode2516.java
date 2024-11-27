package leetCode;

public class LeetCode2516 {
    static int minutes = Integer.MAX_VALUE;
    public static void main(String[] args) {
        
        int minute = 0;
        int k = 2;
        String str = "aabaaaacaabc";
        int left = 0;
        int right = str.length()-1;
        int[] count = new int[3];

        minimumK(str, left, right, count, minute, k);
        System.out.println(minutes);

    }

    public static void minimumK(String str,int left,int right,int[] count,int minute,int k){
        if(count[0] >= k && count[1] >= k && count[2] >= k){
            minutes = Math.min(minutes, minute);
            return;
        }

        if(left > right){
            return;
        }
        count[str.charAt(left) -'a']++;
        minimumK(str, left+1, right, count, minute+1, k);
        count[str.charAt(right) -'a']++;
        minimumK(str, left, right-1, count, minute+1, k);

    }
}
