class Solution {
    int[][] DIRECTIONS = new int[][]{{1,0}, {0,-1}, {-1,0}, {0,1}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i, j});
        grid[i][j] = '0';
        while (que.size() > 0) {
            int[] node = que.remove();
            for (int[] dir : DIRECTIONS) {
                int r = node[0] + dir[0];
                int c = node[1] + dir[1];
                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
                    continue;
                grid[r][c] = '0';
                que.add(new int[]{r,c});
            }
        }
    }
}