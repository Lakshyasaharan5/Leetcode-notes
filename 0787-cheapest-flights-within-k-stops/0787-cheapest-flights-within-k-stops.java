class Edge {
    int to;
    int weight;
    Edge(int t, int w) {
        this.to = t;
        this.weight = w;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        /**
        k = 0         
        q = [(200,2), (700,3)]
        front = (1,100)
        d = [0   100  200   700]
             0   1    2     3
        */

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : flights) {
            graph.get(e[0]).add(new Edge(e[1], e[2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        while (k-- >= 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] front = queue.poll();
                int cost = front[1];
                for (Edge nb : graph.get(front[0])) {
                    if (cost + nb.weight < dist[nb.to]) {
                        dist[nb.to] = cost + nb.weight;
                        queue.offer(new int[]{nb.to, dist[nb.to]});
                    }
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}