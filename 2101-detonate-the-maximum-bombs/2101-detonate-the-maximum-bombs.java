class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int[] u = bombs[i];
            for (int j = i + 1; j < n; j++) {
                int[] v = bombs[j];
                long dx = (long)u[0]-v[0];
                long dy = (long)u[1]-v[1];
                long dist_sq = (dx * dx) + (dy * dy);
                if ((long)u[2] * u[2] >= dist_sq) {
                    // u -> v
                    graph.get(i).add(j);
                }
                if ((long)v[2] * v[2] >= dist_sq) {
                    // v -> u
                    graph.get(j).add(i);
                }
            }
        }
        int max_detonated = 1;
        for (int i = 0; i < n; i++) {
            int detonated = dfs(graph, i, new boolean[n]);
            max_detonated = Math.max(max_detonated, detonated);
        }
        return max_detonated;
        /**
            b1      b2
                b3
                        b4
            b1: [b3,b2]
            b2: [b3]
            b3: []
            b4: [b1, b2, b3]

            b1----------|
                |-------b2
            d(b1,b2) <= r
         */
        
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start, int n) {
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        que.offer(start);
        visited[start] = true;
        while (!que.isEmpty()) {
            int front = que.poll();
            cnt++;
            for (int nb : graph.get(front)) {
                if (!visited[nb]) {
                    visited[nb] = true;
                    que.offer(nb);
                }
            }
        }
        return cnt;
    }

    private int dfs(Map<Integer, List<Integer>> graph, int start, boolean[] visited) {
        if (visited[start]) return 0;        
        visited[start] = true;
        int curr = 0;
        for (int nb : graph.get(start)) {            
                curr += dfs(graph, nb, visited);        
        }
        return curr + 1;
    }
}