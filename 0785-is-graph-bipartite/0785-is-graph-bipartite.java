class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!bfs(i, color, graph)) return false;
            }
        }
        return true;
    }

    private boolean bfs (int start, int[] color, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            int currColor = color[curr];
            for (int nb : graph[curr]) {
                if (color[nb] == 0) {
                    color[nb] = -1 * currColor;
                    q.offer(nb);
                    continue;
                }
                if (color[nb] != -1 * currColor) {
                    return false;
                }
            }
        }
        return true;
    }
}