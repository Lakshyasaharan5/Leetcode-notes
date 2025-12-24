class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) dp[n - 1] = 0;
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else dp[j] += dp[j + 1];
            }
        }
        return dp[0];
    }
}