class Solution {
    int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int uniquePathsIII(int[][] grid) {
        int cellsToVisit = 0;
        int m = grid.length, n = grid[0].length;
        int start_i = 0, start_j = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    start_i = i;
                    start_j = j;
                }
                if (grid[i][j] != -1 && grid[i][j] != 1)
                    cellsToVisit++;
            }
        }
        return dfs(grid, start_i, start_j, cellsToVisit);
    }

    private int dfs(int[][] grid, int i, int j, int cellsToVisit) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) return 0;
        if (cellsToVisit == 0 && grid[i][j] == 2) return 1;
        if (grid[i][j] == 2) return 0;
        grid[i][j] = -1;
        int curr = 0;
        for (int[] d : DIRS) {
            curr += dfs(grid, i + d[0], j + d[1], cellsToVisit - 1);
        }
        grid[i][j] = 0;
        return curr;
    }
}