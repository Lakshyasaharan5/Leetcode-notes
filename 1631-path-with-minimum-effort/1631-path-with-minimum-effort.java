class Solution {
    /**
        [1,2,2],
        [3,8,2],
        [5,3,5]

        pq = [(11,6)(22,3)(11,5)(22,2)]  (r,c,effort)        

        [0,1,1],
        [2,5,1],
        [2,2,2]

    */
    private static int[][] DIR = {{0,1},{1,0},{-1,0},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0,0});
        while (!pq.isEmpty()) {
            int[] front = pq.poll();
            int r = front[0], c = front[1], effort = front[2];
            for (int[] d : DIR) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                    continue;
                }
                int nextEffort = Math.max(effort, Math.abs(heights[r][c] - heights[nr][nc]));
                if (nextEffort < dist[nr][nc]) {
                    dist[nr][nc] = nextEffort;
                    pq.offer(new int[]{nr, nc, nextEffort});
                }
            }
        }
        return dist[rows - 1][cols - 1];
    }
}