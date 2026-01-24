class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        Queue<int[]> queue = null;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;                    
                    queue = new LinkedList<>();
                    grid[i][j] = '0';
                    queue.offer(new int[]{i,j});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();                        
                        for (int[] dir : directions) {
                            int next_i = curr[0] + dir[0];
                            int next_j = curr[1] + dir[1];
                            if (next_i < 0 || next_j < 0 || next_i >= grid.length || next_j >= grid[0].length 
                            || grid[next_i][next_j] == '0') continue;
                            grid[next_i][next_j] = '0';
                            queue.offer(new int[]{next_i, next_j});
                        }
                    }
                }
            }
        }
        return islands;
    }

}