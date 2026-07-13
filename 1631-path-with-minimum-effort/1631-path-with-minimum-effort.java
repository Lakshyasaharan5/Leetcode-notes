class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[]{0, 0, 0});
        int maxEffort = 0;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while (!pq.isEmpty()) {
            int[] front = pq.poll();  //(cost, r, c)
            int cost = front[0], r = front[1], c = front[2];
            visited[r][c] = true;
            maxEffort = Math.max(maxEffort, cost);
            if (r == m - 1 && c == n - 1) break;
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) continue;
                int newCost = Math.abs(heights[r][c] - heights[nr][nc]);
                pq.offer(new int[]{newCost, nr, nc});
            }
        }
        return maxEffort;
        /**
                min-heap (cost, i, j)
                [1,2,2],
                [3,8,2],
                [5,*3,5]

                [(8,6)(8,6)(5,3)(8,5)] min-heap
                (5,2) top
                effort =2
                if (top == last) return effort
                
         */
    }
}