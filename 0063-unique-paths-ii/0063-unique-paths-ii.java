class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(obstacleGrid, 0, 0, dp);
    }

    private int dfs(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || 
            j < 0 || 
            i >= grid.length || 
            j >= grid[0].length || 
            grid[i][j] == 1) return 0;
        if (i == grid.length - 1 && j == grid[0].length - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = dfs(grid, i + 1, j, dp) + dfs(grid, i, j + 1, dp);
    }
}