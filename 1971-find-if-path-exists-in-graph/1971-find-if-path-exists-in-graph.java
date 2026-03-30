class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int src, int dest, Set<Integer> visited) {
        if (src == dest) {
            return true;
        }
        for (int nb : graph.get(src)) {
            if (visited.add(nb)){
                if (dfs(graph, nb, dest, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

}