package sorting;

public class QuickSort {
  public static void main(String[] args) {
    int[] a = {90, -1, 2, 0, 6, 2, -4, 8};
    quickSor(a, 0, a.length - 1);
    for (int a1 : a) {
      System.out.print(a1 + ",");
    }
  }

  public static void quickSor(int[] a, int st, int end) {
    if (st > end) {
      return;
    }
    int p = findPivot(a, st, end);
    quickSor(a, st, p - 1);
    quickSor(a, p + 1, end);
  }

  public static int findPivot(int[] a, int st, int end) {
    int p = a[end];
    int i = st - 1;
    for (int j = st; j <= end - 1; j++) {
      if (a[j] > p) {
        i++;
        swap(a, i, j);
      }
    }
    swap(a, i + 1, end);
    return i + 1;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
