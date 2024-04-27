package backtracking;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PrintAllSubSet {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3};
    printAllSunSet(arr, 0, new ArrayList<>());
  }

  private static void printAllSunSet(int[] arr, int length, ArrayList<Integer> objects) {
    print(objects);
    for (int i = length; i < arr.length; i++) {
      objects.add(arr[i]);
      printAllSunSet(arr, i + 1, objects);

      objects.remove(objects.size() - 1);
    }
  }

  private static void print(ArrayList<Integer> objects) {
    if (objects.isEmpty()) {
      System.out.print("{}");
      return;
    }

    System.out.print("\n{");
   String s = objects.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(","));
    System.out.println(s+"}");
  }
}
