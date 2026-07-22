class Edge {
    int to;
    int color; //0 red, 1 blue
    Edge(int to, int color) {
        this.to = to;
        this.color = color;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] e : redEdges) {
            graph.get(e[0]).add(new Edge(e[1], 0));
        }
        for (int[] e : blueEdges) {
            graph.get(e[0]).add(new Edge(e[1], 1));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<int[]> q = new LinkedList<>(); // (node, color, dist so far)
        q.offer(new int[]{0, 0, 0});
        q.offer(new int[]{0, 1, 0});
        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true;        
        visited[0][1] = true;
        while (!q.isEmpty()) {
            int[] front = q.poll();
            int c = front[1];
            int d = front[2];
            for (Edge nb : graph.get(front[0])) {
                if (c == nb.color || visited[nb.to][nb.color]) continue;
                visited[nb.to][nb.color] = true;
                dist[nb.to] = Math.min(dist[nb.to], d + 1);
                q.offer(new int[]{nb.to, nb.color, d + 1});
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
        /**
            n = 3, 
            redEdges  = [[0,1],[1,2],[2,3],[3,4]], 
            blueEdges = [[1,2],[2,3],[3,1]]

            0---R--->1----RB--->2---RB-->3--R-->4
                     ^--------B---------/

            {1 : (2R, 2B)}
            
            q = [4R7] (node, color, dist)
            front = 3B6
            [0   1   2   3    7]
             0   1   2   3    4

            [0 1 2 3 7]
             0 1 2 3 4
         */
    }
}