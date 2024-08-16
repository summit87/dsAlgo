package trie;

import java.util.ArrayList;
import java.util.List;

/** Longest string in the smallest lexicographical */
public class LongestString {

  static String prev="";
  public static void main(String[] args) {
    String[] strs = {"a", "banana", "app", "appl", "ap", "apply", "apple","appla"};
    TrieNode tn = new TrieNode();
    for (int i = 0; i < strs.length; i++) {
      tn.insertNode(tn, strs[i]);
    }
   List<String> list = new ArrayList<>();
   tn.print(tn,"",list);
   for (String str : list){
     System.out.println(str);
   }
    // String result = "";
    // longestString(tn, result);
    // System.out.println(prev);
  }

  //todo: Need to look into this again
  private static void longestString(TrieNode trieNode, String result) {
    if (trieNode.isWord()) {
      ///System.out.println(result);
      if ((result.length() > prev.length())) {
        if (prev.compareTo(result) < 0) {
          prev = result;
        }
      }
    }
    for (TrieNode trieNode1 : trieNode.getMap().values()) {
      longestString(trieNode1, result + trieNode1.getNode());
    }
  }
}
