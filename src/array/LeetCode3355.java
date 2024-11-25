package array;


/**
 * Zero sum
 * https://leetcode.com/problems/zero-array-transformation-i/description/
 */

public class LeetCode3355 {
    public static void main(String[] args) {
        int[][] query = {{0,2},{1,3}};
        int[] num = {4,3,2,1};
        System.out.println(isArraySumZero(num, query));
    }

    /**
     * The idea to use prefix array
     * prefix array will store how many number of times at a given index we need to reduce the value by -1
     * There are two approach to do this
     * 1. First for each query index range ,eg [i,j] , we can traverse in this range and fill preix array sth like this
     *   for i.. j, prefix[i] = prefix[i]-1
     * 2. 2nd approach is fill prefix array only for start and end index and then do below operation , which will fill the 
     *     the number of operation needs to be done at a given indx
     *    1. for i... n for each query
     *        prefix[query[i][0]] = prefix[query[i][0]] - 1;
     *        prefix[query[i][1]+1] = prefix[query[i][1]+1] + 1; //  this is required to mark the end 
     */


     public static boolean isArraySumZero(int[] num,int[][] query){

        int[] prefix = new int[num.length+1];
        for(int i=0;i<query.length;i++){
            prefix[query[i][0]] = prefix[query[i][0]]-1;
            prefix[query[i][1]+1] = prefix[query[i][i]+1]+1;
        }

        for(int i=1;i<num.length;i++){
            prefix[i] += prefix[i-1];
        }

        for(int i=0;i<num.length;i++){
            if(prefix[i]+num[i] > 0){
                return false;
            }
        }
        return true;
     }


}
