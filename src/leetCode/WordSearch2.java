package leetCode;
import java.util.*;
public class WordSearch2 {
    static Trie trie = new Trie();
    public static void main(String[] args) {
    
        char[][] ch ={{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] word ={"oa","oaa"};
        System.out.println(findWords(ch, word));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> list = new HashSet<>();
      
        for (String word : words) {
            createTrie(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Trie tn = trie;
                isWordExistInMat(board, i, j, tn, list);
            }
        }
        return new ArrayList<>(list);
    }

    public static void isWordExistInMat(char[][] board, int row, int col, Trie tn, Set<String> list) {

        
        if (tn.word() != null) {
            System.out.println(tn.word());
            list.add(tn.word());
            return;
        }

        if (!isValidMove(board, row, col, tn)) {
            return;
        }

        char ch1 = board[row][col];
        board[row][col] = '#';
        int[] r = { 0, -1, 1, 0 };
        int[] c = { -1, 0, 0, 1 };
        for (int i = 0; i < r.length; i++) {
            isWordExistInMat(board, row + r[i], col + c[i], tn.getMap().get(ch1), list);
        }
        board[row][col] = ch1;
        if (tn.getMap().isEmpty()) {
            System.out.println(ch1);
            tn.getMap().remove(ch1);
        }
    }

    public static boolean isValidMove(char[][] board, int row, int col, Trie tn) {
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length
                && tn.getMap().containsKey(board[row][col]));
    }

    public static void createTrie(String word) {
        Trie tn = trie;
        for (Character ch : word.toCharArray()) {
            Map<Character, Trie> map = tn.getMap();
            if (!map.containsKey(ch)) {
                Trie tr1 = new Trie(ch);
                map.put(ch, tr1);
                tn.setMap(map);
            }
            tn = tn.getMap().get(ch);
        }
        tn.setIsWord(true);
        tn.setWord(word);
    }
}

class Trie {
    Map<Character, Trie> map;
    Character ch;
    boolean isWord;
    String word;

    public Trie() {
        map = new HashMap<>();
    }

    public Trie(Character ch) {
        map = new HashMap<>();
        this.ch = ch;
    }

    public String word() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Map<Character, Trie> getMap() {
        return map;
    }

    public void setMap(Map<Character, Trie> map) {
        this.map = map;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    public boolean isWord() {
        return this.isWord;
    }
}
