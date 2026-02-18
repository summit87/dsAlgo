package linkedin;

public class LeetCode152 {
    public static void main(String[] args) throws InterruptedException {
        int[] a={2,3,-2,4,3,9,10};
        
        System.out.println(maxProduct(a));
        
        
    }

    public static int maxProduct(int[] a){
        int max = a[0];
        int minProdTill = a[0];
        int max1 = Integer.MIN_VALUE;
        for(int i=1;i<a.length;i++){
            int temp = max*a[i];
            max = Math.max(minProdTill*a[i], Math.max(temp, a[i]));
            minProdTill = Math.min(minProdTill*a[i],Math.min(temp, a[i]));
           
            max1 = Math.max(max1, max);
        }
        return max1;
    }
}
