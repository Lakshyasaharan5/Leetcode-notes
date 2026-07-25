class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = Integer.MIN_VALUE;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
        /**
                 1 2 3 2 1
                 3 2 1 4 7

                 1 2 1
                 2 1 1

                  1 2 1
                2 0 2 0
                1 1 0 1
                1 1 0 1


                  1 2 3 2 1
                3 0 0 3 0 0
                2 0 1 0 2 0
                1 1 0 0 0 1
                4 0 0 0 0 0
                7 0 0 0 0 0
        
         */
    }
}