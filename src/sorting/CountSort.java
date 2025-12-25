package sorting;

public class CountSort {
    public static void main(String[] args) {
        int[] a = {2,5,3,0,2,3,0,3};
        for(int a1 : count(a)){
            System.out.print(a1+",");
        }
    }

    public static int[] count(int[] a){
        int[] res =new int[a.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i < a.length;i++){
            max = Math.max(max, a[i]);
        }
        int[] count = new int[max+1];
        for(int i=0;i<a.length;i++){
            count[a[i]]++;
        }
        for(int i=1;i<=max;i++){
            count[i]+=count[i-1];
        }
        for(int i=0;i<a.length;i++){
            res[count[a[i]]-1] = a[i];
            count[a[i]]--;
        }
        return res;
    }
}
