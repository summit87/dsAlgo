import java.util.TreeMap;

public class Judge {
    public static void main(String[] args) {
        int n=4;
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(extracted(trust, n));
    }

    private static int extracted(int[][] trust, int n) {
        System.out.println(trust.length);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < trust.length; i++) {
            int x = 1;
            if (map.containsKey(trust[i][1])) {
                x += map.get(trust[i][1]);
            }
            map.put(trust[i][1], x);
        }
        System.out.println(map);
        for (Integer i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                System.out.println(","+map.get(i));
                if (map.get(i).equals(map.lastKey())) {

                    return -1;
                }
            }
        }
        return map.lastKey().intValue();
    }
}
