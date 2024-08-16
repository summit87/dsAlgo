package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
  private Character node;
  private Map<Character, TrieNode> map;
  private boolean isWord;
  private String word;

  public TrieNode() {
    map = new HashMap<>();
  }

  public TrieNode(Character node) {
    this.node = node;
    map = new HashMap<>();
  }

  public Character getNode() {
    return node;
  }

  public void setNode(Character node) {
    this.node = node;
  }

  public Map<Character, TrieNode> getMap() {
    return map;
  }

  public void setMap(Map<Character, TrieNode> map) {
    this.map = map;
  }

  public boolean isWord() {
    return isWord;
  }

  public void setWord(boolean word) {
    isWord = word;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public void insertNode(TrieNode tn, String word) {
    TrieNode trieTree = tn;
    for (int i = 0; i < word.length(); i++) {
      Character ch = word.charAt(i);
      Map<Character, TrieNode> root = trieTree.getMap();
      if (!root.containsKey(ch)) {
        TrieNode tr = new TrieNode(ch);
        root.put(ch, tr);
        trieTree.setMap(root);
      }
      trieTree = trieTree.getMap().get(ch);
    }
    trieTree.setWord(true);
    trieTree.setWord(word);
  }

  public boolean findWord(String word, TrieNode trieNode) {
    TrieNode tn1 = trieNode;
    for (int i = 0; i < word.length(); i++) {
      Character ch = word.charAt(i);
      Map<Character, TrieNode> mapping = tn1.getMap();
      if (!mapping.containsKey(ch)) {
        return false;
      }
      tn1 = tn1.getMap().get(ch);
    }
    return tn1.isWord();
  }

  public void print(TrieNode trieNode, String str, List<String> list) {
    if (trieNode.isWord()) {
      list.add(str);
    }
    if (null == trieNode || trieNode.getMap().isEmpty()) {
      return;
    }
    // for (TrieNode t : trieNode.getMap().values()) {
    //   print(t, str + String.valueOf(t.getNode()), list);
    // }

    for (Map.Entry<Character,TrieNode> map  : trieNode.getMap().entrySet()) {
      print(map.getValue(), str + String.valueOf(map.getKey()), list);
    }
  }
}


