package stringP;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String[] s =  { "grace", "graceful", 
        "disgraceful","gracefully" };

        String[] s1 = {"sadness", "sad", "sadly"};
        String[] s2 = {"sadness", "sadnar", "xadnly","adadn"};
        longestCommonSubString(s2);
    }

    public static void longestCommonSubString(String[] a){
       
        String s = a[0];
        int count = 0;
        int maxLen = Integer.MIN_VALUE;
        int previous = 0;
        String s1 = "";
        for(int i=0;i<s.length();i++){
            int j=i+1;
            while(j < s.length()){
                count = 0;
                String s3 = s.substring(i,j+1);

               for(int x=1;x<a.length;x++){
                if(a[x].contains(s3)){
                    count++;
                }
               }
                if(count == a.length-1 && previous < s3.length()){
                    maxLen = count;
                    s1 = s3;
                    previous = s3.length();
                }
                j++;
            }
        }
        System.out.println(s1 +" : "+maxLen);
    }
}
