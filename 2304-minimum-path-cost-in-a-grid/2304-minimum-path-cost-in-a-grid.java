class Solution {
    /**
        grid = [[5,1,2],
                [4,0,3]], 
        
        moveCost = [[12,10,15],
                    [20,23,8],
                    [21,7,1],
                    [8,1,13],
                    [9,10,25],
                    [5,3,2]]

        moveCost[grid[r][c]][0->n]

        5          1
      4 0 3       4 0 3      ..
        return min(cost4, cost0, cost3) + 5
     */
    private int dfs(int[][] grid, int r, int c, int[][] moveCost, int[][] dp) {
        if (r == grid.length - 1) return grid[r][c];
        if (dp[r][c] != -1) return dp[r][c];
        int min = Integer.MAX_VALUE;
        for (int nc = 0; nc < grid[0].length; nc++) {
            min = Math.min(min, dfs(grid, r + 1, nc, moveCost, dp) + moveCost[grid[r][c]][nc]);
        }
        return dp[r][c] = min + grid[r][c];
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) Arrays.fill(dp[i], -1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            min = Math.min(min, dfs(grid, 0, i, moveCost, dp));
        }
        return min;
    }
}