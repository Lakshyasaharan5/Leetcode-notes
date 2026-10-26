class Solution {
    /**
        heights = [

        [1,2,2,3,5],
        [3,2,3,4,4],
        [2,4,5,3,1],
        [6,7,1,4,5],
        [5,1,1,2,4]]

        [1,1,1,1,3],
        [1,1,1,3,3],
        [1,1,3,2,2],
        [3,3,2,2,2],
        [3,2,2,2,2]]

        pacific -> (0,c), (r,0)
        atlantic -> (m,c), (r,n)




     */
    private static final int[][] DIR = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        
        // pacific sides
        int[][] pacific = new int[m][n];
        for (int c = 0; c < n; c++) {
            if (pacific[0][c] == 0) {
                dfs(heights, pacific, 0, c);
            }
        }
        for (int r = 0; r < m; r++) {
            if (pacific[r][0] == 0) {
                dfs(heights, pacific, r, 0);
            }
        }

        // atlantic sides
        int[][] atlantic = new int[m][n];
        for (int c = 0; c < n; c++) {
            if (atlantic[m - 1][c] == 0) {
                dfs(heights, atlantic, m - 1, c);
            }
        }
        for (int r = 0; r < m; r++) {
            if (atlantic[r][n - 1] == 0) {
                dfs(heights, atlantic, r, n - 1);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // System.out.print(atlantic[r][c] + " ");
                if (pacific[r][c] == 1 && atlantic[r][c] == 1) {
                    res.add(Arrays.asList(r, c));
                }
            }
            // System.out.println();
        }
        
        return res;
    }

    private void dfs(int[][] heights, int[][] dp, int r, int c) {
        dp[r][c] = 1;
        for (int[] d : DIR) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && dp[nr][nc] == 0 && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, dp, nr, nc);
            }            
        }
    }
}