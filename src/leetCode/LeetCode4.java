package leetCode;

public class LeetCode4 {
    public static void main(String[] args) {
        int[] a1 = { 1, 2, 4,9,11 };
        int[] a2 = { 3,6,12,13,14};
        System.out.println(median(a1, a2));
    }

    private static float median(int[] a1, int[] a2) {
        float m1 = -1;
        float m2 = -1;
        int c = (a1.length + a2.length) / 2;
        int i = 0;
        int j = 0;
        for (int c1 = 0; c1 <= c; c1++) {
            if (i < a1.length && j < a2.length) {
                if (a1[i] < a2[j]) {
                    m1 = a1[i];
                    i++;
                } else if (a1[i] > a2[j]) {
                    m2 = a2[j];
                    j++;
                }
            }
        }

        if (i == a1.length) {
            m2 = a2[0];
        } else if (j == a2.length) {
            m1 = a1[0];
        }

        if ((a1.length + a2.length) % 2 == 1) {
            return m1;
        }

        return (m1 + m2) / 2;

    }
}
