class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connection = new boolean[n][n];
        int[] degree = new int[n];
        for (int[] edge : roads) {
            int u = edge[0], v = edge[1];
            connection[u][v] = true;
            connection[v][u] = true;
            degree[u]++;
            degree[v]++;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, degree[i] + degree[j] - (connection[i][j] ? 1 : 0));
            }
        }
        return res;
    }
}