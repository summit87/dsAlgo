package array;

public class BoyerMooreVotingAlgo {
    public static void main(String[] args) {
        int[] a = {1,1,2,1,3,5,1};
        findMajorityElement(a);
        
    }

    public static void findMajorityElement(int[] a){
        int val = -1;
        int count =0;

        for(int i=0;i<a.length;i++){
            if(count == 0){
                count++;
                val = a[i];
            }else if(val == a[i]){
                count++;
            }else{
                count--;
            }
        }

        for(int i=0;i<a.length;i++){
            if(val == a[i]){
                count++;
            }
        }
        System.out.println(val+" : "+count);
    }
}
