package stringP;

public class AnagramSearching {
    public static void main(String[] args) {
        String pattern = "ABCD";
        String text = "BACDGABCDA";
        anagramSearching(text, pattern);
    }

    /**
     * This is in O(N)
     * @param str
     * @param pattern
     */
    /**
     * Another algo, 
     * 1. we can use take all the substring and sort that substring and see if sorted string equal to patter
     * 2. We can take all the substring and create map of each substring and store the charater count , if all the pattern charecter are matching 
     * , then that will aslo the anagram
     * 
     * @param str
     * @param pattern
     */
    public static void anagramSearching(String str,String pattern){
        int hashP = 0;
        int hashT = 0;
        for(int i=0;i<pattern.length();i++){
            hashP =hashP + (pattern.charAt(i) - 'A');
        }

        for(int i=0;i<pattern.length();i++){
            hashT += (str.charAt(i) - 'A');
        }

        if(hashP == hashT){
            System.out.println("Found at 0");
        }

        for(int i=1;i<=str.length() - pattern.length();i++){
            hashT += (str.charAt(pattern.length()-1+i) - 'A') - (str.charAt(i-1) - 'A');
            if(hashP == hashT){
                System.out.println("Found at "+i);
            }
        }
    }
}
