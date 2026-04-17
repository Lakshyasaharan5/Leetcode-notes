class Edge {
    int to;
    int color; // 0-red 1-blue
    public Edge(int to, int color) {
        this.to = to;
        this.color = color;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : redEdges) {
            graph.get(edge[0]).add(new Edge(edge[1], 0));
        }
        for (int[] edge : blueEdges) {
            graph.get(edge[0]).add(new Edge(edge[1], 1));
        }
        Integer[][] visited = new Integer[n][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        visited[0][0] = 1;
        visited[0][1] = 1;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int u = curr[0], color = curr[1];
                for (Edge neib : graph.get(u)) {
                    int v = neib.to;
                    if (visited[v][neib.color] != null) continue;
                    if (neib.color == color) {

                    } else {
                        res[v] = Math.min(res[v], level);
                        visited[v][neib.color] = 1;
                        q.offer(new int[]{v, neib.color});
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE)
                res[i] = -1;
        }
        return res;
    }
}