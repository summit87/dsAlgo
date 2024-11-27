package leetCode;

/**
 * Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
 */
public class LeetCode3356 {
    public static void main(String[] args) {
        int[] nums = {5};
        int[][] query = { {0,0,5}, { 0,0,5 },{0,0,3}};
        System.out.println(minimumK(nums, query));
    }

    public static int minimumK(int[] nums, int[][] query) {

        int[][] prefix = new int[query.length ][nums.length + 1];

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
        //     for (int c1 = 0; c1 < prefix[r1].length; c1++) {
        //        System.out.print(prefix[r1][c1]+",");
        //     }
        //     System.out.println();
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
