class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colors = new int [n + 1];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            int u = edge[0] - 1, v = edge[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;
            while (!queue.isEmpty()) {
                int front = queue.poll();
                for (int nb : graph[front]) {
                    if (colors[nb] == 0) {
                        queue.offer(nb);
                        colors[nb] = -1 * colors[front];
                    } else if (colors[nb] == colors[front]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}