package leetCode;

public class LeetCode875 {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h=8;
        System.out.println(minCount(piles, h));
    }

    public static int minCount(int[] piles,int h){
        int x = 1;
        while(true){
            int hours = 0;
            for(int p :piles){
                hours+=Math.ceil(p/x);
            }

            if(hours == h){
                return x;
            }
            x++;
        }
    }
}
