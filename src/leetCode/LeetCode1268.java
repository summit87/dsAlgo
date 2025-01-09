package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1268 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cats","callow","but","bukwas","bramha","butterfly","builder");
        String word = "cat";
        Collections.sort(words);
        Trie1268 tn = new Trie1268();
        for(String w :  words){
            tn.insert(w, tn);
        }
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<word.length();i++){
            List<String> op = new ArrayList<>();
            autoComplete(new StringBuilder(""), word.substring(0, i+1), op, tn);
            if(op.size() > 3){
                Collections.sort(op);
                res.add(op.subList(0, 3));
            }else{
                Collections.sort(op);
                res.add(op);
            }
        }
        System.out.println(res);
    }

    public static void autoComplete(StringBuilder word,String prefix,List<String> op,Trie1268 tn){
        if(tn.iisWord() && word.toString().trim().contains(prefix)){
            op.add(word.toString().trim());
            return;
        }

        for(Trie1268 tn1 : tn.map().values()){
            int len = word.length();
            word.append(tn1.ch());
            autoComplete(word, prefix, op, tn1);
            word.setLength(len);
        }
    }
}

class Trie1268{
    private boolean isWord;
    private Character character;
    private Map<Character,Trie1268> map;

    public Trie1268(){
        map = new HashMap<>();
    }

    public Trie1268(Character ch){
        this.character = ch;
        map= new HashMap<>();
    }

    public Map<Character,Trie1268> map(){
        return map;
    }

    public void setWord(boolean isWord){
        this.isWord = isWord;
    }

    public boolean iisWord(){
        return isWord;
    }
    public void setMap(Map<Character,Trie1268> map){
        this.map = map;
    }

    public Character ch(){
        return character;
    }

    public void insert(String word,Trie1268 tn){
        Trie1268 tn1= tn;
        for(Character ch :  word.toCharArray()){
            Map<Character,Trie1268> map = tn1.map();
            if(!map.containsKey(ch)){
                Trie1268 tn2 = new Trie1268(ch);
                map.put(ch, tn2);
                tn1.setMap(map);
            }
            tn1= tn1.map().get(ch);
        }
        tn1.setWord(true);
    }
}
