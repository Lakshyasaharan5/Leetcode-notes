class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] from_n1 = new int[n];
        int[] from_n2 = new int[n];
        bfs(edges, from_n1, node1);
        bfs(edges, from_n2, node2);
        int res = Integer.MAX_VALUE;
        int res_index = 0;
        for (int i = 0; i < n; i++) {            
            int max_dist = Math.max(from_n1[i], from_n2[i]);
            if (res > max_dist) {
                res = max_dist;
                res_index = i;
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res_index;
        /**
        from_1 = [~ 0 1 2]
                  0 1 2 3
        from_0 = [0 ~ 1 2]
                  0 1 2 3
        
        
        from_0 = [0 1 2]
                  0 1 2 3
        from_2 = [~ ~ 0]
                  0 1 2 3
         */
    }

    private void bfs(int[] edges, int[] from, int start) {
        Arrays.fill(from, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        visited[start] = true;
        q.offer(start);
        from[start] = 0;
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int front = q.poll();
            int nb = edges[front];
            if (nb == -1 || visited[nb])
                continue;
            visited[nb] = true;
            from[nb] = level;
            q.offer(nb);
        }
    }
}