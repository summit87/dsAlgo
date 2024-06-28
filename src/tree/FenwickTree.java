package tree;

public class FenwickTree {

    public static void main(String[] args) {
        int x = 13;
        x = x - (x & -x);
        System.out.println(x);
    }
}
