package leetCode;

public class LeetCode650 {
    public static void main(String[] args) {
        System.out.println(minSteps(1, 1, 3));
    }

    public static int minSteps(int previousCopied,int current,int n) {
         if(previousCopied == n){
            return 0;
        }
        if(previousCopied > n){
            return 1000000;
        }
       

        int f1 = 2+minSteps(previousCopied*2, previousCopied, n);
        int f2 = 1+minSteps(previousCopied+current, current,n);
        return Math.min(f1, f2);
    }


}
