package leetCode;

import java.util.*;

public class LeetCode2354 {
    public static void main(String[] args) {
        int[][] prefix = {{38,26},{3,32},{2,1}};
        count(prefix);
    }

    public static int count(int[][] prefix){
        int count = 1;
        List<int[]> prefixList = new ArrayList<>();
        for(int i=0;i<prefix.length;i++){
            int[] x = new int[]{prefix[i][0],prefix[i][1]};
            prefix[i][0] = x[0] - x[1];
            prefix[i][1] = x[0] + x[1];
            prefixList.add(prefix[i]);
        }
        Collections.sort(prefixList, (int[] a,int[] b) -> (a[0] - b[0]));
        for(int i=0;i<prefixList.size();i++){
            System.out.println(prefixList.get(i)[0]+" : "+prefixList.get(i)[1]);
        }
        return 1;
    }
}
