package linkedin;

public class LeetCode50 {
    public static void main(String[] args) {
        System.out.println(pow(2, 3));
    }

    public static int pow(int x,int n){
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
