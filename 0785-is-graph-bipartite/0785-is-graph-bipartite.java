class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Set<Integer> red = new HashSet<Integer>();
        Set<Integer> green = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (red.contains(i) || green.contains(i)) continue;
            if (!dfs(graph, i, true, red, green)) return false;
        }
        return true;                
    }

    private boolean dfs(int[][] graph, int node,
            boolean isRed, Set<Integer> red, Set<Integer> green) {
        if (isRed) {
            if (green.contains(node)) return false;
            if (red.contains(node)) return true;
            red.add(node);
        } else {
            if (red.contains(node)) return false;
            if (green.contains(node)) return true;            
            green.add(node);
        }
        for (int neib : graph[node]) {
            if (!dfs(graph, neib, !isRed, red, green)) return false;
        }
        return true;
    }
}