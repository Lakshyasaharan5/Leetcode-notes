class Edge {
    String to;
    double weight;
    public Edge(String to, double weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Edge>> graph = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        int k = 0;
        for (List<String> query : queries) {
            String u = query.get(0);
            String v = query.get(1);
            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                res[k] = (double)-1;
            } else {
                Set<String> visited = new HashSet<>();
                res[k] = dfs(graph, u, v, visited);
            }
            k++;
        }
        return res;
    }

    private double dfs(HashMap<String, ArrayList<Edge>> graph, String src, String dest, Set<String> visited) {
        if (src.equals(dest)) {
            return 1.0;
        }
        
        visited.add(src);
        for (Edge edge : graph.get(src)) {
            String nb = edge.to;
            if (!visited.contains(nb)){
                double prod = dfs(graph, edge.to, dest, visited) * edge.weight;
                if (prod >= 0) {
                    return prod;
                }
            }            
        }
        return -1.0;
    }

    private HashMap<String, ArrayList<Edge>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<Edge>());
            }
            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList<Edge>());
            }
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, 1/w));
        }
        return graph;
    }
}