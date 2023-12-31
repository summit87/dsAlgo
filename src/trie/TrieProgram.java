package trie;

import java.util.ArrayList;
import java.util.List;

public class TrieProgram {
  public static void main(String[] args) {
    String[] strs = {"a","banana","app","appl","ap","apply","apple"};
    TrieNode trieNode = new TrieNode();
    for (String s : strs) {
      trieNode.insertNode(trieNode, s);
    }
    //System.out.println(trieNode.findWord("flow", trieNode));
      List<String> list = new ArrayList<>();
    trieNode.print(trieNode,"",list);
    for (String str : list){
      System.out.println(str);
    }
  }
}
