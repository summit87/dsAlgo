package leetCode;

public class WordSearch1 {
    public static void main(String[] args) {
        char[][] ch = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        for(int i=0;i<ch.length;i++){
            for(int j = 0;j < ch[0].length;j++){
                if(isWord(ch, i, j, 0, word)){
                    System.out.println("Found");
                    break;
                }
            }
        }
    }


    public static boolean isWord(char[][] board,int row,int col,int index,String word){
        if(index >= word.length()){
            return true;
        }

        if(!isValid(board, row, col, index, word)){
            return false;
        }

        char ch = board[row][col];
        board[row][col] = '#';
        int[] row1 = {0,1,-1,0};
        int[] col1 = {1,0,0,-1};
        for(int i=0;i<row1.length;i++){
            if(isWord(board, row+row1[i], col+col1[i], index+1, word)){
                return true;
            }
        }
        board[row][col]=ch;
        return false;
        
    }

    public static boolean isValid(char[][] ch,int row,int col,int ind,String word){
        return (row >= 0 && row < ch.length && col >= 0 && col < ch[0].length && ind < word.length() && word.charAt(ind) == ch[row][col]);
    }
}
