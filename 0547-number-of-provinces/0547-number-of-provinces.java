class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {            
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {                
                dfs(graph, i, visited);
                provinces++;
            }            
        }
        return provinces;
        /**
               0 1 2
             0[1,1,0]
             1[1,1,0]
             2[0,0,1]                     
         */

    }

    private void dfs(Map<Integer, List<Integer>> graph, int start, boolean[] visited) {
        if (visited[start]) return;
        visited[start] = true;
        for (int nb : graph.get(start)) {
            dfs(graph, nb, visited);
        }
    }
}