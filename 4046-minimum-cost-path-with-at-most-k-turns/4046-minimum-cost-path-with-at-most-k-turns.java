class Solution {
    /**
            00 01 02
            10 11 12
            20 21 22

            k=1
            [2,7,3],
            [1,4,5]

            [up, right, down, left]
            [01, 10, 0-1, -10]
              0   1   2     3

            pq = [(00,2,1,0)(00,2,1,1)(00,2,1,2)(00,2,1,3)]   (rc, cost, remainging turns, prev dir)
            
            dist[m][n][k][direction] m*n*k*4
            [ 2  9   ~][]
            [ 3  7  12][]

     */
    int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};
    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][][] dist = new int[m][n][k + 1][4];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int remainK = 0; remainK <= k; remainK++) {
                    for (int dirIndex = 0; dirIndex < 4; dirIndex++) {
                        if (i == 0 && j == 0) {
                            dist[i][j][remainK][dirIndex] = grid[i][j];
                        } else {
                            dist[i][j][remainK][dirIndex] = Integer.MAX_VALUE;
                        }                        
                    }
                }
            }
        }
        pq.offer(new int[]{0,0,grid[0][0],k,0});
        pq.offer(new int[]{0,0,grid[0][0],k,1});
        pq.offer(new int[]{0,0,grid[0][0],k,2});
        pq.offer(new int[]{0,0,grid[0][0],k,3});

        while (!pq.isEmpty()) {
            int[] front = pq.poll();
            int r = front[0], c = front[1], cost = front[2], remainK = front[3], prevDir = front[4];
            if (dist[r][c][remainK][prevDir] < cost) continue;
            for (int di = 0; di < 4; di++) {
                int nr = r + DIR[di][0];
                int nc = c + DIR[di][1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (prevDir == di) {
                    if (cost + grid[nr][nc] < dist[nr][nc][remainK][di]) {
                        dist[nr][nc][remainK][di] = cost + grid[nr][nc];
                        pq.offer(new int[]{nr, nc, cost + grid[nr][nc], remainK, di});
                    }
                } else {
                    if (remainK == 0) continue;
                    if (cost + grid[nr][nc] < dist[nr][nc][remainK - 1][di]) {
                        dist[nr][nc][remainK - 1][di] = cost + grid[nr][nc];
                        pq.offer(new int[]{nr, nc, cost + grid[nr][nc], remainK - 1, di});
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int remainK = 0; remainK <= k; remainK++) {
            for (int di = 0; di < 4; di++) {
                res = Math.min(res, dist[m - 1][n - 1][remainK][di]);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}