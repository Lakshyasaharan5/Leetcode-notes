class Edge {
    int to;
    double probability;
    public Edge(int to, double p) {
        this.to = to;
        this.probability = p;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            graph.get(u).add(new Edge(v, p));
            graph.get(v).add(new Edge(u, p));
        }

        double[] best = new double[n];
        best[start] = 1.0;

        PriorityQueue<double[]> pq =
            new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        pq.offer(new double[]{1.0, start});

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            double prob = curr[0];
            int u = (int) curr[1];

            if (prob < best[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                double newProb = prob * edge.probability;

                if (newProb > best[v]) {
                    best[v] = newProb;
                    pq.offer(new double[]{newProb, v});
                }
            }
        }

        return best[end];
    }
}