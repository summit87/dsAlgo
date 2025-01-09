package leetCode;

public class LeetCode2116 {
    public static void main(String[] args) {
        String str="))())(";
        String locked = "010101";
        System.out.println(isValidParenthesis(str, locked));
    }

    public static boolean isValidParenthesis(String str, String locked) {

        int openCnt = 0;
        int unLockedCount = 0;
        int x = 0;
        /**
         * In first time iteration , we will try to validate the parenthesis as much as possible
         */
        for (int i = 0; i < str.length(); i++) {
            if (locked.charAt(i) == '0') {
                unLockedCount++;
            } else if (str.charAt(i) == '(') {
                openCnt++;
            } else {
                if (str.charAt(i) == ')') {
                    if(openCnt > 0){
                        openCnt--;
                    }
                    else if (unLockedCount > 0) {
                        unLockedCount--;
                    }else{
                        return false;
                    }
                }
            }
            if (unLockedCount == 0 && openCnt == 0) {
               x = i;
            }
    
        }
        /**
         * x will tell us till what index in string we have vailidated the parenthesis
         */

        if (unLockedCount == 0 && openCnt == 0) {
            return true;
        }


        int b = 0;

        /**
         * This loop make sure , we are vailidating rest of the string
         */

        for (int i = str.length() - 1; i > x; i--) {
            if (locked.charAt(i) == '0') {
                b--;
                unLockedCount--;
            } else if (str.charAt(i) == '(') {
                b++;
                openCnt--;
            } else {
                if (str.charAt(i) == ')') {
                    b--;
                }
            }

            if (b > 0) {
                return false;
            }
        }

        if (openCnt > 0) {
            return false;
        }

        return true;
    }
}
