package leetCode;

/**
 * Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
 */
public class LeetCode3356 {
    public static void main(String[] args) {
        int[] nums = { 4,3,2,1 };
        int[][] query = { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } };
        System.out.println(minimumK1(nums, query));
    }

    public static int minimumK1(int[] nums, int[][] query) {
        int ans = 0;

        int left = 0;
        int right = query.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (isAllArrayZeroElement(nums, query, mid)) {
                ans = mid+1;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isAllArrayZeroElement(int[] nums, int[][] query, int mid) {
       
        int[] prefix = new int[nums.length+1];

        for(int i=0;i<=mid;i++){
            prefix[query[i][0]] += prefix[query[i][0]]-query[i][2];
            prefix[query[i][1]+1] += prefix[query[i][1]+1]+query[i][2];
        }

        for(int i=1;i<prefix.length;i++){
            prefix[i]+=prefix[i-1];
        }


        for(int i=0;i<nums.length;i++){
            if(prefix[i]+nums[i] > 0){
                return false;
            }
        }

        return true;
    }

    /*************************************************************
     * THE BELOW TEST CASE IS NOT WORKING BY USINF 2D PREFIX SUM *
     * NUMS = *
     * [0] *
     * QUERIES = *
     * [[0,0,2],[0,0,4],[0,0,4],[0,0,3],[0,0,5]] *
     * USE TESTCASE *
     * OUTPUT *
     * 1 *
     * EXPECTED *
     * 0 *
     *************************************************************/

    public static int minimumK(int[] nums, int[][] query) {

        int[][] prefix = new int[query.length][nums.length + 1];

        int row = 0;
        for (int i = 0; i < query.length; i++) {
            int val = query[i][2];
            if (row == 0) {
                prefix[row][query[i][0]] = prefix[row][query[i][0]] - val;
                prefix[row][query[i][1] + 1] = prefix[row][query[i][1] + 1] + val;

            } else {
                prefix[row][query[i][0]] = prefix[row - 1][query[i][0]] + prefix[row][query[i][0]] - val;
                prefix[row][query[i][1] + 1] = prefix[row - 1][query[i][1] + 1] + prefix[row][query[i][1] + 1] + val;
            }
            row++;
        }

        for (int r1 = 0; r1 < row; r1++) {
            for (int c1 = 1; c1 < prefix[r1].length; c1++) {
                prefix[r1][c1] += prefix[r1][c1 - 1];
            }
        }

        // for (int r1 = 0; r1 < row; r1++) {
        // for (int c1 = 0; c1 < prefix[r1].length; c1++) {
        // System.out.print(prefix[r1][c1]+",");
        // }
        // System.out.println();
        // }

        for (int r1 = 0; r1 < row; r1++) {
            boolean flag = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                if (prefix[r1][i] + nums[i] != 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                return r1 + 1;
            }
        }

        return -1;
    }

}
