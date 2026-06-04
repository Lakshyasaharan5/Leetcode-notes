class Solution {
    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return dfs(grid, 0, 0, dp);
    }

    private int dfs(int[][] grid, int i, int j, Integer[][] dp) {
        if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if (dp[i][j] != null) return dp[i][j];
        int down = dfs(grid, i + 1, j, dp);
        int right = dfs(grid, i, j + 1, dp);
        return dp[i][j] = Math.min(down, right) + grid[i][j];
    }
}