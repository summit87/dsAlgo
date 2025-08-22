package maths;

public class Maths1 {
    public static void main(String[] args) {
        int n = 39;
        int a = (int) Math.floor(Math.log(n) / Math.log(2));
        int b = (int) Math.ceil(Math.log(n) / Math.log(2));
        System.out.println(a+" : "+b);
    }
}
 