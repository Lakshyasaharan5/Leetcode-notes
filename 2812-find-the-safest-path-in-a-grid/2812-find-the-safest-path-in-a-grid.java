class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dp[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }                    
            }
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int r = front[0], c = front[1];
            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || dp[nr][nc] != Integer.MAX_VALUE)
                    continue;
                dp[nr][nc] = dp[r][c] + 1;
                queue.offer(new int[]{nr, nc, dp[nr][nc]});
            }
        }
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]); 
        pq.offer(new int[]{dp[0][0], 0, 0});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] front = pq.poll();
            int minSafety = front[0];
            int r = front[1], c = front[2];        
            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc])
                    continue;
                visited[nr][nc] = true;                
                int currMin = Math.min(minSafety, dp[nr][nc]);
                if (nr == n - 1 && nc == n - 1) return currMin;
                pq.offer(new int[]{currMin, nr, nc});
            }
        }
        return 0;
        /**
                2 1 0      2 1 0 dist[]    00 01 02
                1 2 1      1 1 1           10 11 12
                0 1 2      0 1 _           20 21 22
                pq = [(0,02)(0,20)(1,12)]    (min safe, r, c) max heap
                (1,21)
         */ 
        
    }
}