package leetCode;
/**
 * https://leetcode.com/problems/valid-parenthesis-string/editorial/
 */
public class LeetCode678 {
    public static void main(String[] args) {
        String str = "(*)(";
        boolean[][] mem = new boolean[str.length()][str.length()];
        System.out.println(isValidString(str));
    }

    public static boolean isValidString(String str){

        int closeCnt=0;
        int openCnt = 0;
        int len = str.length()-1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '*'){
                openCnt++;
            }else{
                openCnt--;
            }

            if(str.charAt(len-i) == ')' || str.charAt(len-i) == '*'){
                closeCnt++;
            }else{
                closeCnt--;
            }
            if(openCnt <0 || closeCnt< 0){
                return false;
            }
        }
        
        return true;
    }

    /**
     * "(*)"
     * @param str
     * @param index
     * @param opt
     * @param mem
     * @return
     */
    public static boolean isValidString(String str,int index,int opt,boolean[][] mem){
        if(index == str.length()){
            return opt == 0;
        }
        

        if(mem[index][opt]){
            return true;
        }

        boolean isValid = false;
        if(str.charAt(index) == '*'){
            isValid |= isValidString(str, index+1, opt+1, mem); // 2 , opt : 2 , next '(' , indx =2
            if (opt > 0) {
                isValid |= isValidString(str, index+1, opt-1, mem);
            }
            isValid |= isValidString(str, index+1, opt, mem);
        }
        if(str.charAt(index) == '('){
            isValid |= isValidString(str, index+1, opt+1, mem); // 1 , opt : 1
        }else if(opt > 0){
            isValid |= isValidString(str, index+1, opt-1, mem);
        }
        mem[index][opt] = isValid;
        return mem[index][opt];
    }


    public static void usingDp(String str){
        boolean[][] dp = new boolean[str.length()+1][str.length()+1];

    }
}
