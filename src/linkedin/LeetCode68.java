package linkedin;

import java.util.ArrayList;
import java.util.List;

public class LeetCode68 {
    /**
     * Text Justification
     * 
     * @param args
     * 
     *             Input: words = ["This", "is", "an", "example", "of", "text",
     *             "justification."], maxWidth = 16
     *             Output:
     *             [
     *             "This is an",
     *             "example of text",
     *             "justification. "
     *             ]
     * 
     */
    public static void main(String[] args) {
        String[] str = { "This", "is", "an", "example", "of", "text", "justification." };
        int maxLength = 16;
        for (String word : getWord(str, maxLength)) {
            System.out.println(word);
        }
    }

    public static List<String> getWord(String[] str, int maxLength) {
        List<String> words = new ArrayList<>();
        int space = 0;
        int extraSpace = 0;
        int remainingSpace = 0;
        int word =0;
        for (int i = 0; i < str.length;) {
            word = str[i].length();
            space = 0;
            int j = i + 1;
            while (j < str.length && word + space + str[j].length()+1 < maxLength) {
                word += str[j].length();
                space++;
                j++;
            }
            extraSpace = space != 0 ? (maxLength - (word)) / space : 0;
            remainingSpace = space != 0 ? (maxLength - (word)) % space : 0;
            String line = getLine(extraSpace, remainingSpace, i, j, str,maxLength);
            words.add(line);
            i = j;
        }
        return words;
    }

    private static String getLine(int extraSpace, int remainingSpace, int i, int j, String[] str,int maxLength) {
        String word = "";
        for (int x = i; x < j; x++) {
            word += str[x];
            for (int z = 1; z <= extraSpace && word.length() < maxLength; z++) {
                word += "$";
            }

            if (remainingSpace > 0) {
                word += "$";
            remainingSpace--;
            }

        }
        return word;
    }
}
