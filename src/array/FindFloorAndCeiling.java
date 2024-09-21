package array;

public class FindFloorAndCeiling {
    public static void main(String[] args) {
        int[] a = {5, 6, 8, 9, 6, 5, 5, 6};
        int x = 7;
        int[] fc = floorAndCeling(a, x);
        System.out.println(fc[0]+" : "+fc[1]);
    }

    private static int[] floorAndCeling(int[] a, int x) {
        int[] fc = new int[2];
        int floor = Integer.MIN_VALUE;
        int ceiling = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (floor < x && a[i] < x) {
                floor = a[i];
            }

            if (ceiling > a[i] && a[i] > x) {
                ceiling = a[i];
            }
        }
        fc[0] = floor;
        fc[1] = ceiling;

        return fc;
    }
}
