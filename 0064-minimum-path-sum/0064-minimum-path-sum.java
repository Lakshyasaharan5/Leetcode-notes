class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];        
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
            }
        }
        return dp[0][0];
        /**
            [[1,3,1],
             [1,5,1],
             [4,2,1]] 
             
             dp[i][j] = min(r,d) + grid[i][j]
                * ->
                V
              1 3
              1 5
                        ij
                    i+1,j   i,j+1

                            00
                        /         \
                      10             01
                   /    5\        /     \ 
                 ~      11      11       ~
                 dp[i][j]
                 return min(d, r) + curr
         */
    }
}