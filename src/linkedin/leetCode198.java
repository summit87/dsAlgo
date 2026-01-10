package linkedin;

public class leetCode198 {
    public static void main(String[] args) {
        int[] a = {2,7,9,3,1};
        System.out.println(houseRober(a));
    }

    private static int houseRober(int[] a){
        int incl = a[0];
        int excl = a[1];

        for(int i=2;i < a.length;i++){
            int temp = excl;
            incl = Math.max(excl, incl+a[i]);
            excl = incl;
            incl = temp;
        }

        return Math.max(incl, excl);
    }
}
