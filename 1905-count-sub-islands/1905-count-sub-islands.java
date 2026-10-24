class Solution {
    /**
        0  0  0
        1  0  1
        0  1  1

        0  0  0
        1  0  0
        1  0  1 

        q = [(10)]
        
        isSubIsland = false
        
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslandsCount = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    subIslandsCount++;
                }
            }
        }
        return subIslandsCount;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {
        if (r < 0 || c < 0 || r >= grid2.length || c >= grid2[0].length || grid2[r][c] == 0) {
            return true;
        }
        grid2[r][c] = 0;
        return  dfs(grid1, grid2, r + 1, c) &
                dfs(grid1, grid2, r - 1, c) &
                dfs(grid1, grid2, r, c + 1) &
                dfs(grid1, grid2, r, c - 1) &
                grid1[r][c] == 1;

    }

    private boolean bfs(int[][] grid1, int[][] grid2, int r, int c) {
        boolean isSubIsland = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        grid2[r][c] = 0;
        if (grid1[r][c] != 1) {
            isSubIsland = false;
        }
        int[][] DIR = {{0,1},{1,0},{-1,0},{0,-1}};
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            for (int[] d : DIR) {
                int nr = front[0] + d[0];
                int nc = front[1] + d[1];
                if (nr >= 0 && nc >= 0 && nr < grid2.length && nc < grid2[0].length && grid2[nr][nc] == 1) {
                    if (grid1[nr][nc] != 1) {
                        isSubIsland = false;
                    }
                    grid2[nr][nc] = 0;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return isSubIsland;
    }
}