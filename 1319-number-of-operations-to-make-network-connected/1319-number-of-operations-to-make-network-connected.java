class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (bfs(graph, i, visited))
                components++;            
        }
            
        return components - 1;
    }

    private boolean bfs(Map<Integer, List<Integer>> graph, int start, boolean[] visited) {
        if (visited[start]) return false;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int computer = queue.poll();
            for (int neib : graph.get(computer)) {
                if (!visited[neib]) {
                    visited[neib] = true;
                    queue.offer(neib);
                }
            }
        }
        return true;
    }
}