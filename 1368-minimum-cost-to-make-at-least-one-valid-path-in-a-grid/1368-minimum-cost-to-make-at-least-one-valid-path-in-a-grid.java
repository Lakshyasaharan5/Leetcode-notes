class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // {cost, i, j}

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int i = curr[1], j = curr[2];

            if (cost > dist[i][j]) continue;

            for (int d = 0; d < 4; d++) {
                int r = i + dirs[d][0];
                int c = j + dirs[d][1];

                if (r < 0 || c < 0 || r >= m || c >= n) continue;

                // direction mapping:
                // 1 → right, 2 → left, 3 → down, 4 → up
                int nextWeight = (grid[i][j] == d + 1) ? 0 : 1;

                if (dist[i][j] + nextWeight < dist[r][c]) {
                    dist[r][c] = dist[i][j] + nextWeight;
                    pq.offer(new int[]{dist[r][c], r, c});
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}