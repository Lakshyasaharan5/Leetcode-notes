class Solution {
    private static final int[][] DIR = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
    public boolean checkValidGrid(int[][] grid) {
        /**
            kk 01 02 03 04
            10 11 12 13 14
            20 21 kk 23 24
            30 31 32 33 34
            40 41 42 43 44

            22 -> 03,01 43,41 10,30 14,34

            r+2,c+1/-1
            r-2,c+1/-1

            r+1/-1,c+2
            r+1/-1,c-2

            {2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}

            00 to n-1,n-1

            [*,*,*],
            [*,8,*],
            [*,*,*]

            dfs(r,c, count):
                if (count == n*n - 1) return true
                try all dir
                    check(count + 1)
                        if (dfs(r,c, count+1))
                            return true
                return false

         */
        if (grid[0][0] != 0) return false;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int[][] grid, int r, int c, int count) {
        if (count == grid.length * grid.length - 1) return true;
        for (int[] d : DIR) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid.length || grid[nr][nc] != count + 1) 
                continue;
            if (dfs(grid, nr, nc, count + 1)) {
                return true;
            }
        }

        return false;
    }
}