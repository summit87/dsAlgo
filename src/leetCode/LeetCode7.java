package leetCode;

public class LeetCode7 {
    public static void main(String[] args) {
        Integer x = -123;
        Integer res = 0;
        int i=0;
        int temp = Math.abs(x);
        // while(temp > 0){
        //     temp = temp/10;
        //     i++;
        // }
        // temp = Math.abs(x);
        // while(temp > 0 ){
        //     int val = temp % 10;
        //     temp /= 10;
        //     res = ((int)(Math.pow(10, i-1))*val)+res;
        //     i--;
        // }
        // System.out.println((x > 0 ? res : res*-1));

        while(temp > 0){
            int val = temp % 10;
            temp /= 10;
            int val1 = res*10+val;
            res = val1;
        }

        System.out.println(res);
    }
}
