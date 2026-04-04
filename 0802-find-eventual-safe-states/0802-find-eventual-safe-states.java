class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            dfs(graph, i, visiting, visited);
        }
        // sort visited
        List<Integer> res = new ArrayList<>(visited);
        res.sort((a, b) -> a - b);
        return res;
    }

    private boolean dfs(int[][] graph, int node, Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(node)) return false;
        if (visited.contains(node)) return true;
        visiting.add(node);
        for (int nextNode : graph[node]) {
            if (!dfs(graph, nextNode, visiting, visited)) return false;
        }
        visiting.remove(node);
        visited.add(node);
        return true;
    }
}