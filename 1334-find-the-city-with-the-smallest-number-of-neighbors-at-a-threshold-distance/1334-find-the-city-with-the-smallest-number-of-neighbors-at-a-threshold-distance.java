class Edge {
    int to;
    int d;
    Edge(int to, int d) {
        this.to = to;
        this.d = d;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(new Edge(e[1], e[2]));
            graph.get(e[1]).add(new Edge(e[0], e[2]));
        }
        int largestCity = 0, minReachable = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int reachable = dijkstra(graph, i, distanceThreshold);
            // System.out.println(reachable);
            if (reachable <= minReachable) {
                minReachable = reachable;
                largestCity = i;
            }
        }
        return largestCity;
        /**
            (0)---3----(1)----1------------(2)
                        \                   /
                         \---4---(3)----1--/
        
            pq = [(1,4)] (node,dist)
                (2,1)
            [3,1,2]

            reachable = 2
            node = 0
        */
    }

    private int dijkstra(Map<Integer, List<Edge>> graph, int start, int th) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        }); // (node, dist)
        pq.offer(new int[]{start, 0});
    
        while (!pq.isEmpty()) {
            int[] front = pq.poll();
            int node = front[0];
            int dist = front[1];
            if (visited.contains(node)) continue;
            visited.add(node);
            for (Edge nb : graph.get(node)) {
                if (dist + nb.d <= th && !visited.contains(nb.to)) {                    
                    pq.offer(new int[]{nb.to, dist + nb.d});
                }
            }
        }
        return visited.size() - 1;
    }
}