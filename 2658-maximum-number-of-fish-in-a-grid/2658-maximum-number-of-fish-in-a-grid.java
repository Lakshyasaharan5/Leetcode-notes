class Solution {
    int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};
    public int findMaxFish(int[][] grid) {
       /**
            [[0,2,1,0],
             [4,0,0,3],
             [1,0,0,4],
             [0,3,2,0]]
        */ 
        int m = grid.length, n = grid[0].length;
        int maxFish = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                maxFish = Math.max(maxFish, dfs(grid, i, j));
            }
        }
        return maxFish;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
            return 0;        
        int curr = grid[r][c];
        grid[r][c] = 0;
        for (int[] d : DIR) {
            int nr = r + d[0];
            int nc = c + d[1];
            curr += dfs(grid, nr, nc);
        }
        return curr;
    }
}