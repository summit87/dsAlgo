package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetProblem {
  public static void main(String[] args) {
    int[] val = {1, 2, 1};
    int sum = 3;
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    calculate(val, sum, set, list, 0);
  }

  private static void calculate(
      int[] val, int sum, Set<Integer> set, List<Integer> list, int index) {
    if (sum == 0) {
     list.forEach(System.out::println);
      System.out.println("************************");
      return;
    }
    for (int i = index; i < val.length; i++) {
     // set.add(val[i]);
      sum -= val[i];
      list.add(val[i]);
      calculate(val, sum, set, list, i + 1);
     // set.remove(set.size() - 1);
      int v = list.remove(list.size() - 1);
      sum += v;
    }
  }
}
