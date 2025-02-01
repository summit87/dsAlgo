import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilityFile {
    public static void main(String[] args) {
        
    }



    /**
     * How to sort the 2D array based (represented as co-ordinate system)
     * @param prefix
     * @return
     */
     public static int count(int[][] prefix){
        int count = 1;
        List<int[]> prefixList = new ArrayList<>();
        for(int i=0;i<prefix.length;i++){
            prefix[i][0] = prefix[i][0] - prefix[i][1];
            prefix[i][1] = prefix[i][0] + prefix[i][1];
            prefixList.add(prefix[i]);
        }
        // sort list of the 1d array
        Collections.sort(prefixList, (int[] a,int[] b) -> (a[0] - b[0]));

        // sort 2d array
        /**
         * 
         *  // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });
         */
        Arrays.sort(prefix,(int[] a,int[] b) -> (a[0] - b[0]));
        for(int i=0;i<prefixList.size();i++){
            System.out.println(prefixList.get(i)[0]+" : "+prefixList.get(i)[1]);
        }
        return 1;
     }
}
