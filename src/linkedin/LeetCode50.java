package linkedin;

public class LeetCode50 {
    public static void main(String[] args) {
        System.out.println(1/pow(2, 2));
    }

    public static double  pow(int x,int n){
        if(n == 0){
            return 1;
        }

        if(n == 1){
            return x;
        }
        if(n % 2 != 0){
            return x*pow(x*x, n/2);
        }
        return pow(x*x, n/2);
    }
}
