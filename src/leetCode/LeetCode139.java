package leetCode;

import java.util.*;

public class LeetCode139 {
    public static void main(String[] args) {
        String woString = "leetcode";
        List<String> list = Arrays.asList("leet","code");
        System.out.println(findIfSementationCanbeDoneUsingTrie(list, woString));
        Set<String> set = new HashSet<>(list);
        System.out.println(isSentenceMakable(woString, set, 0,""));
    }

    /**
     * The idea to use BFS ,
     * considering every character are connected with eachother to make graph,
     * @param s
     * @param word
     * @return
     */
    
    public static boolean findIfSementationCanbeDone(List<String> list,String word){
        /**
         * TC to add list to hashSet : o(K), considering K word in list
         */
        Set<String> set = new HashSet<>(list);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[word.length()+1];
        /**
         * TC : O(N)
         */
        while (!queue.isEmpty()) {
            int ind = queue.poll();
            if(ind == word.length() && visited[ind]){
                return true;
            }
            /**
             * TC : O(N)
             */
            for(int end = ind+1;end<=word.length();end++){
                if(visited[end]){
                    continue;
                }
                /**
                 * TC for getting substring : O(N)
                 */
                if(set.contains(word.substring(ind,end)) && !visited[end]){
                    queue.add(end);
                    visited[end] = true;
                }
            }
        }
        /**
         * Over all TC : O(N3)+O(k)
         */
        return false;
    }

    public static boolean findIfSementationCanbeDoneUsingTrie(List<String> list,String word){

        boolean[] visited = new boolean[word.length()];
        TrieNode139 trieNode139 = new TrieNode139();
        for(String str : list){
            trieNode139.insertWord(str, trieNode139);
        }
        for(int i=0;i<word.length();i++){
            if(i == 0 || visited[i-1]){
                TrieNode139  tempTrie = trieNode139;
                for(int j = i;j<word.length();j++){
                    Map<Character,TrieNode139> map = tempTrie.getTrieNode();
                    if(!map.containsKey(word.charAt(j))){
                        break;
                    }
                    tempTrie = map.get(word.charAt(j));
                    if(tempTrie.isWord()){
                        visited[j] = true;
                    }
                }
            }
        }
        return visited[word.length()-1];
    }



    public static boolean isSentenceMakable(String word,Set<String> set,int index,String str){

        if(index == word.length()){
            return true;
        }
        
        for(int ind = index;ind < word.length();ind++){
            str = word.substring(index, ind+1);
           
            if(set.contains(str) && isSentenceMakable(word, set, ind+1, str)){
                return true;
            }
           
        }
       
        return false;
    }






}

class TrieNode139{
    private boolean isWord;
    private Map<Character,TrieNode139> map;
    private TrieNode139 tn;
    private Character character;
    public TrieNode139(){
        map = new HashMap<>();
    }

    public TrieNode139(Character ch){
        this.character = ch;
        map = new HashMap<>();
    }

    public TrieNode139 getTrie(){
        return tn;
    }

    public Map<Character,TrieNode139> getTrieNode(){
        return map;
    }

    public boolean isWord(){
        return isWord;
    }

    public void setTrieNode(Map<Character,TrieNode139> map){
        this.map = map;
    }

    public void setWord(boolean isWord){
        this.isWord = isWord;
    }

    public void insertWord(String word,TrieNode139 tn){
        TrieNode139 tn1 = tn;
        for(int i=0;i<word.length();i++){
            Map<Character,TrieNode139> trieMap = tn1.getTrieNode();
            if(!trieMap.containsKey(word.charAt(i))){
                TrieNode139 chTrie = new TrieNode139(word.charAt(i));
                trieMap.put(word.charAt(i), chTrie);
                tn1.setTrieNode(trieMap);
            }
            tn1 = tn1.getTrieNode().get(word.charAt(i));
            if(i == word.length()-1){
                tn1.setWord(true);
               
            }
        }

    }


    public boolean findWord(String word,TrieNode139 tn){
        TrieNode139 tn1 = tn;
        for(int i=0;i<word.length();i++){
            Map<Character,TrieNode139> map = tn1.getTrieNode();
            if(!map.containsKey(word.charAt(i))){
                return false;
            }
            tn1 = map.get(word.charAt(i));
        }
        return tn1.isWord();
    }

}
