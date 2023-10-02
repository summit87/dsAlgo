package graph;

/** https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/ */
public class Lexicographically {
  public static void main(String[] args) {
    String s1 = "";
    String s2 = "";
    String baseStr = "";
    s1 = "hello";
    s2 = "world";
    baseStr = "hold";
    int[] size = new int[26];
    int[] set = new int[26];
    for (int i = 0; i < 26; i++) {
      size[i] = 1;
      set[i] = i;
    }

    for (int i = 0; i < s1.length(); i++) {
      makeSet(set, size, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
    }
    System.out.printf(findLexicographicallySmallest(baseStr, set));
  }

  static int find(int[] set, int v) {
    if (set[v] == v) {
      return v;
    }
    return find(set, set[v]);
  }

  static void makeSet(int[] set, int[] size, int ch1, int ch2) {
    int pCh1 = find(set, ch1);
    int pCh2 = find(set, ch2);
    if (pCh1 == pCh2) {
      return;
    }

    if (size[pCh1] <= size[pCh2]) {
      if (pCh1 < pCh2) {
        set[pCh2] = pCh1;
        size[pCh1]++;
      } else {
        set[pCh1] = pCh2;
        size[pCh2]++;
      }
    } else {
      if (pCh1 < pCh2) {
        set[pCh2] = pCh1;
        size[pCh1]++;
      } else {
        set[pCh1] = pCh2;
        size[pCh2]++;
      }
    }
  }

  static String findLexicographicallySmallest(String baseStr, int[] set) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < baseStr.length(); i++) {
      sb = sb.append((char) (find(set, ((int) baseStr.charAt(i) - 'a')) + 97));
    }
    return sb.toString();
  }
}
