package sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {23,1,10,5,2};
        a = insertionSort(a);
        for(int k : a){
            System.out.print(k+",");
        }
    }

    public static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }
}
