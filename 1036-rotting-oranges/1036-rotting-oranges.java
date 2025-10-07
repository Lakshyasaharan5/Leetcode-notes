class Solution {
    int[][] DIRECTIONS = new int[][]{{1,0}, {0,-1}, {-1,0}, {0,1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    que.add(new int[]{i,j});
                }
            }
        }
        int min = bfs(grid, que);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return min;
    }

    private int bfs(int[][] grid, Queue<int[]> que) {
        int min = 0;
        while (que.size() > 0) {     
            int currSize = que.size();       
            for (int i = 0; i < currSize; i++) {
                int[] orange = que.remove();
                for (int[] dir : DIRECTIONS) {
                    int r = orange[0] + dir[0];
                    int c = orange[1] + dir[1];
                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) continue;
                    grid[r][c] = 2;
                    que.add(new int[]{r,c});            
                }
            }   
            if (que.size() > 0) min++;         
        }
        return min;
    }
}