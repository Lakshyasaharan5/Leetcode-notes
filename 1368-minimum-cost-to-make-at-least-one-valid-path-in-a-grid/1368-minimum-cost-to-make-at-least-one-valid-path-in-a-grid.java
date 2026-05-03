class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        d[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // w, i, j
        int[][] DIRECTIONS = new int[][]{{-1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];            
            int r = curr[1], c = curr[2];
            if (cost > d[r][c]) continue;
            for (int i = 1; i <= 4; i++) {
                int[] dir = DIRECTIONS[i];
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;               
                if (cost + (grid[r][c] == i ? 0 : 1) < d[nr][nc]) {
                    d[nr][nc] = cost + (grid[r][c] == i ? 0 : 1);
                    pq.offer(new int[]{d[nr][nc], nr, nc});
                }
            }
        }
        return d[m - 1][n - 1];
    }
}