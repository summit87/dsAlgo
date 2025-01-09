package leetCode;
import java.util.*;
public class LeetCode140 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("cat","cats","and","sand","dog");
        String word = "catsanddog";
        // TrieNode140 tn  = new TrieNode140();
        // for(String sr : list){
        //     tn.insert(sr, tn);
        // }    
        List<String> vals = new ArrayList<>();
        sentanceWithBackTracking("", 0, word, vals, new HashSet<>(list),new StringBuilder());
        System.out.println(vals);
    }

    public static void sentanceWithBackTracking(String word,int index,String originalString,List<String> list,Set<String> set,StringBuilder x){
        if(index == originalString.length()){
            list.add(x.toString().trim());
            return;
        }

        for(int st = index+1;st <= originalString.length();st++){
            word=originalString.substring(index, st);
            if(set.contains(word)){
                int len = x.length();
                x.append(word).append(" ");
                sentanceWithBackTracking( word, st, originalString, list, set,x);
               x.setLength(len);
            }  
        }

    }
}


class TrieNode140{
    private Map<Character,TrieNode140> map;
    private boolean isWord;
    private Character character;

    public TrieNode140(Character character){
        this.character = character;
        map = new HashMap<>();
    }

    public TrieNode140(){
        this.map = new HashMap<>();
    }

    public Map<Character,TrieNode140> map(){
        return map;
    }

    public void setMap(Map<Character,TrieNode140> map){
        this.map= map;
    }

    public void setWord(boolean bn){
        this.isWord = bn;
    }

    public boolean isWord(){
        return isWord;
    }

    public void insert(String word,TrieNode140 tn){
        TrieNode140 tn1= tn;
        for(int i=0;i<word.length();i++){
            Map<Character,TrieNode140> map1 = tn1.map();
            Character ch = word.charAt(i);
            if(!map1.containsKey(ch)){
                TrieNode140 tn2 = new TrieNode140(ch);
                map1.put(ch, tn2);
                tn1.setMap(map1);
            }
            tn1 = tn1.map().get(ch);
        }
        tn1.setWord(true);
    }

}

