class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }

        int minutes = -1;
        while (q.size() > 0) {            
            minutes++;
            int currSize = q.size();
            for (int i = 0; i < currSize; i++) {
                int[] curr = q.poll();
                for (int[] dir : DIRECTIONS) {
                    int nextI = curr[0] + dir[0];
                    int nextJ = curr[1] + dir[1];
                    if (nextI >= 0 && nextJ >= 0 &&
                            nextI < grid.length && nextJ < grid[0].length &&
                            grid[nextI][nextJ] == 1) {
                        grid[nextI][nextJ] = 2;
                        q.add(new int[] { nextI, nextJ });
                    }
                }
            }  
                      
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes == -1 ? 0 : minutes;
    }
}