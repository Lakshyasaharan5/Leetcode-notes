class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.putIfAbsent(i, new ArrayList<>());
        for (int[] pre : prerequisites) {
            int u = pre[0], v = pre[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);            
        }        

        boolean[][] reachable = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dfs(i, i, graph, reachable);
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            if (reachable[q[0]][q[1]]) res.add(true);
            else res.add(false);
        }
        return res;
    }

    private void dfs(int src, int dst, Map<Integer, List<Integer>> graph, boolean[][] reachable) {
        if (reachable[src][dst]) return;
        for (int nb : graph.get(dst)) {            
            dfs(src, nb, graph, reachable);
            reachable[src][nb] = true;
        }
    }
}