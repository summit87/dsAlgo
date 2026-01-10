package linkedin;

public class LeetCode611 {
    public static void main(String[] args) {
        int[] a = { 2, 2, 3, 4, 5 };
        
        int count = 0;
        for (int i = a.length - 1; i >= 2; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (a[j] + a[k] > a[i]) {
                    count += (k - j);
                    k--;
                    continue;
                }
                j++;
            }
        }
        System.out.println(count);
    }
}
