package dp;

public class LeetCode2915 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        System.out.println(longestCommonEle(a, 9, a.length));
    }

    public static int longestCommonEle(int[] a, int sum, int len) {
        if (len <= 0 || sum < 0) {
            return 0;
        }

        if (sum == 0)
            return 0;

        if (sum >= a[len - 1]) {
            return 1 + longestCommonEle(a, sum - a[len - 1], len - 1);
        }

        return Math.max(longestCommonEle(a, sum - a[len - 1], len - 1), longestCommonEle(a, sum, len - 1));
    }

}
