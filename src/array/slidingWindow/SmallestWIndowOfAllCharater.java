package array.slidingWindow;

public class SmallestWIndowOfAllCharater {
    public static void main(String[] args) {
        String s = "timetopractice";
        String t = "toc";
        System.out.println(smallestWindow(s, t));
    }

    private static int smallestWindow(String s, String t) {
        int minWindow = Integer.MAX_VALUE;
        for (int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                String s2 = s.substring(i,j);
                
                if(isAllCharacterExist(s2,t)){
                    if(minWindow > (j-i)){
                        minWindow = (j-i);
                    }
                }
            }
        }
        return minWindow;   
    }

    private static boolean isAllCharacterExist(String s,String p){

        int[] a = new int[26];
        for(int i=0;i<p.length();i++){
            a[p.charAt(i) - 'a']++ ;
        }

        for(int i=0;i<s.length();i++){
            if(a[s.charAt(i) - 'a'] > 0){
                a[s.charAt(i) - 'a']--;
            }
        }

        for(int i=0;i<p.length();i++){
            if(a[p.charAt(i) -'a'] > 0){
                return false;
            }
        }
        return true;
    }
}
