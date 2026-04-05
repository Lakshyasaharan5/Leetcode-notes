class Solution {
    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                provinces++;
            }
        }
        return provinces;        
    }

    private void dfs(int[][] graph, int city, boolean[] visited) {
        if (visited[city]) return;
        visited[city] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[city][i] == 1) {
                dfs(graph, i, visited);
            }
        }
    }
}