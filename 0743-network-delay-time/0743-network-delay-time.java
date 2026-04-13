class Edge {
    int to;
    int weight;
    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new Edge(v, w));
        }
        boolean[] visited = new boolean[n + 1];
        int[] shortest = new int[n + 1];
        for (int i = 1; i <= n; i++) shortest[i] = Integer.MAX_VALUE;
        shortest[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1], dist = curr[0];
            if (visited[u]) continue;
            visited[u] = true;
            for (Edge edge : graph.get(u)) {
                int v = edge.to, w = edge.weight;
                if (shortest[u] + w < shortest[v]) {
                    shortest[v] = shortest[u] + w;
                    pq.offer(new int[]{shortest[v], v});
                }                
            }
        }
        int time = -1;
        for (int i = 1; i <= n; i++) time = Math.max(time, shortest[i]);
        return time == Integer.MAX_VALUE ? -1 : time;
    }
}