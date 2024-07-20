package sorting;

public class SelectionSorting {
    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11};
        a = sort(a);
        for(int a1 : a){
            System.out.print(a1+",");
        }
    }

    private static int[] sort(int [] a){

        for(int i=0;i<a.length-1;i++){
            int minVal = a[i];
            int minIndex = i;
            int j = i+1;
            while( j< a.length){
                if(minVal > a[j]){
                    minVal = a[j];
                    minIndex = j;
                }
                j++;
            }

            int temp = a[i];
            a[i] = minVal;
            a[minIndex] = temp;
        }

        return a;
    } 
}
