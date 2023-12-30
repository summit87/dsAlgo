package trie;

import java.util.Map;

public class TrieNode {
    private Character node;
    private Map<Character,TrieNode> map;
    private boolean isWord;

    public TrieNode() {
    }

    public TrieNode(Character node) {
        this.node = node;
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

    public void insertNode(TrieNode tn,String word){
        TrieNode trieTree = tn;
        for (int i = 0;i<word.length();i++){
            Character ch = word.charAt(i);
            Map<Character,TrieNode> root = trieTree.getMap();
            if (!root.containsKey(ch)){
                TrieNode tr = new TrieNode(ch);
                root.put(ch,tr);
                trieTree.setMap(root);
            }
            trieTree = trieTree.getMap().get(ch);
        }
    }
}
