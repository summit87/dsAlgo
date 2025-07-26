package leetCode;

public class FrogJump {
    public static void main(String[] args) {
        int[] a = {30,10,60};
        System.out.println(minJum2(a, 0));
    }

    public static int minJump(int[] a,int len){
        if(len+1 >= a.length || len >= a.length){
            return 0;
        }

        int f1 = minJump(a, len+1)+Math.abs(a[len] - a[len+1]);
        int f2 = Integer.MAX_VALUE;
        if(len+2 < a.length){
            f2 = minJump(a, len+2)+Math.abs(a[len] - a[len+2]);
        }
        return Math.min(f1,f2);

    }

    public static int minJum1(int[] a,int len){
        int[] dp = new int[a.length+1];
        for(int i=a.length-2;i >= 0;i--){
            int f1 = dp[i+1]+Math.abs(a[i] - a[i+1]);
            int f2 = Integer.MAX_VALUE;
            if(i+2 < a.length){
                f2 = dp[i+2]+Math.abs(a[i] - a[i+2]);
            }

            dp[i] = Math.min(f1, f2);
        }
        return dp[0];
    }
    

    public static int minJum2(int[] a,int len){
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        for(int i=1;i <= a.length-1;i++){
            int f1 = temp1+Math.abs(a[i] - a[i-1]);
            int f2 = Integer.MAX_VALUE;
            if(i-2 >= 0){
                f2 = temp2+Math.abs(a[i] - a[i-2]);
            }

            temp3 = Math.min(f1, f2);
            temp2 = temp1;
            temp1 = temp3;
        }
        return temp3;
    }
    

}
