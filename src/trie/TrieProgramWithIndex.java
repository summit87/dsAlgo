package trie;
import java.util.*;
public class TrieProgramWithIndex {
    public static void main(String[] args) {
        TrieNodeWithIndex trieNodeWithIndex = new TrieNodeWithIndex();
        List<String> words = Arrays.asList("cats","callow","but","bukwas","bramha","butterfly","builder");
        for(String w:words){
            trieNodeWithIndex.insertWord(w, trieNodeWithIndex);
        }
        String word = "but";
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<word.length();i++){
            List<String> op = new ArrayList<>();
            autoSuggestion(word.substring(0, i+1), res, trieNodeWithIndex, new StringBuilder(), op);
            if(op.size() > 3){
                res.add(op.subList(0, 3));
            }
        }
       // System.out.println(trieNodeWithIndex.findWord("cats", trieNodeWithIndex));
    }


    public static void autoSuggestion(String prefix,List<List<String>> res,TrieNodeWithIndex trieNodeWithIndex,StringBuilder word,List<String> list){
        if (trieNodeWithIndex == null) {
            return;
        }
        if(trieNodeWithIndex != null && trieNodeWithIndex.isWord() && word.toString().trim().contains(prefix)){
            list.add(word.toString().trim());
            return;
        }
        for(int i=0;i<26;i++){
            trieNodeWithIndex = trieNodeWithIndex.getTrieNodeWithIndices()[i];
            int len = word.toString().length();
            word.append(trieNodeWithIndex.getCharacter());
            autoSuggestion(prefix, res,  trieNodeWithIndex.getTrieNodeWithIndices()[i], word, list);
            word.setLength(len);
        }
    }
}
