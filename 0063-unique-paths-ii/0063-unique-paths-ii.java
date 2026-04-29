class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //    1 1 % 1
    //   [1 1 1 *]
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                dp[j] += (j < n - 1 ? dp[j + 1] : 0);
            }
        }

        return dp[0];
    }
}