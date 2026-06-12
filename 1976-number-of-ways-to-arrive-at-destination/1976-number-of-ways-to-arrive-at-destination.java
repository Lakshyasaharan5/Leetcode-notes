class Edge {
    int to;
    int time;
    public Edge(int to, int time) {
        this.to = to;
        this.time = time;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        long[] ways = new long[n];
        ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0}); // time, node
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int)curr[1];
            if (dist[u] < (int)curr[0]) continue;
            for (Edge nb : graph.get(u)) {
                int v = nb.to, t = nb.time;
                if (dist[u] + t < dist[v]) {
                    dist[v] = dist[u] + t;
                    pq.offer(new long[]{dist[v], v});
                    ways[v] = ways[u];
                } else if (dist[u] + t == dist[v]) {
                    ways[v] = (ways[u] + ways[v]) % 1000000007;
                }
            }
        }
        return (int)(ways[n - 1] % 1000000007);
    }
}