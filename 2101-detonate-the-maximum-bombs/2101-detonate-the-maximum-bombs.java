class Solution {
    public int maximumDetonation(int[][] bombs) {
        int N = bombs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int[] u = bombs[i];
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }
            for (int j = i + 1; j < N; j++) {
                if (!graph.containsKey(j)) {
                    graph.put(j, new ArrayList<>());
                }
                int[] v = bombs[j];  
                long dx = u[0] - v[0];
                long dy = u[1] - v[1];
                long distSq = dx * dx + dy * dy;
                
                long r1 = (long)u[2] * u[2];
                long r2 = (long)v[2] * v[2];              
                
                // can u detonate v
                if (r1 >= distSq) {
                    graph.get(i).add(j);
                }   
                // can v detonate u
                if (r2 >= distSq) {
                    graph.get(j).add(i);
                }
            }            
        }
        int detonate = 0;
        for (int bomb = 0; bomb < N; bomb++) {
            boolean[] visited = new boolean[N];
            detonate = Math.max(detonate, dfs(graph, bomb, visited));
        }
        return detonate;
    }

    private int dfs(Map<Integer, List<Integer>> graph, int bomb, boolean[] visited) {
        if (visited[bomb]) return 0;
        visited[bomb] = true;
        int curr = 0;
        for (int nextBomb : graph.get(bomb)) {            
            curr += dfs(graph, nextBomb, visited);
        }
        return curr + 1;
    }
}