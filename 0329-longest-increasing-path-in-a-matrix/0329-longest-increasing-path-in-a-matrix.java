class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {                
                dp[i][j] = dfs(matrix, dp, i, j, -1);                
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
        /**
                [3,4,5],
                [3,2,6],
                [2,2,1]

                [4,3,2],
                [1,4,1],
                [2,1,2]
        
                dfs over all
                    dp[i][j] = max(left, right, top, down) + 1
         */
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == -1 || prev >= matrix[i][j]) return 0;
        int curr = matrix[i][j];
        matrix[i][j] = -1;
        if (dp[i][j] != -1) {
            matrix[i][j] = curr;
            return dp[i][j];
        }        
        int left = dfs(matrix, dp, i, j - 1, curr);
        int right = dfs(matrix, dp, i, j + 1, curr);
        int top = dfs(matrix, dp, i - 1, j, curr);
        int down = dfs(matrix, dp, i + 1, j, curr);
        matrix[i][j] = curr;
        return dp[i][j] = Math.max(Math.max(left, right), Math.max(top, down)) + 1;
    }
}