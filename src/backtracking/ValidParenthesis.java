package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    generateAllValid("(v)())()", list, "",0);
    list.forEach(System.out::println);
  }

  private static void generateAllValid(String s, List<String> list, String s1,int index) {
    if (isValid(s1) && !list.contains(s1)) {
      list.add(s1);
    }
    for (int i=index;i<s.length();i++){
      generateAllValid(s,list,s.substring(0,i)+s.substring(i+1),i+1);
    }
  }

  private static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch != ')') {
        if (ch == '(') {
          count++;
        }
        continue;
      }
      count--;
      if (count < 0){
        return false;
      }
    }
    return count == 0 ;
  }
}
