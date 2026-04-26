class Edge {
    String to;
    double w;
    public Edge(String to, double w) {
        this.to = to;
        this.w = w;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, 1/w));
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = bfs(graph, queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    private double bfs(Map<String, List<Edge>> graph, String src, String dst) {
        if (!graph.containsKey(src) || !graph.containsKey(dst)) return -1.0;
        if (src.equals(dst)) return 1.0;
        Queue<Edge> q = new LinkedList<>();        
        Set<String> visited = new HashSet<>();
        q.offer(new Edge(src, 1));       
        visited.add(src);
        while (!q.isEmpty()) {
            Edge curr = q.poll();
            String u = curr.to;
            double division = curr.w;
            for (Edge neib : graph.get(u)) {
                String v = neib.to;
                double w = neib.w;
                if (visited.contains(v)) continue;
                visited.add(v);
                if (v.equals(dst)) return division * w;
                q.offer(new Edge(v, division * w));
            }
        }
        return -1.0;
    }
}