class Solution {
    public int minPathSum(int[][] grid) {        
        int m = grid.length - 1, n = grid[0].length - 1;        
        // prefix fill bottom 
        int j = n - 1;
        while (j >= 0) {
            grid[m][j] += grid[m][j + 1];
            j--;
        }

        // prefix fill right
        int i = m - 1;
        while (i >= 0) {
            grid[i][n] += grid[i + 1][n];
            i--;
        }

        // fill the rest curr += min(i,j);
        for (i = m - 1; i >= 0; i--) {
            for (j = n - 1; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
            }
        }

        return grid[0][0];
    }
}