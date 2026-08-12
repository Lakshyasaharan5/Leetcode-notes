class Edge {
    int to;
    int cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());
        for (int[] e : flights) {
            int u = e[0], v = e[1], cost = e[2];
            graph.get(u).add(new Edge(v, cost));
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>(); 
        q.offer(new int[]{src, 0}); //node, cost
        k++;
        while (k-- > 0) {
            int size = q.size();
            while (size-- > 0) {                
                int[] front = q.poll();
                int u = front[0], cost = front[1];
                for (Edge nb : graph.get(u)) {
                    if (cost + nb.cost < dist[nb.to]) {
                        dist[nb.to] = cost + nb.cost;
                        q.offer(new int[]{nb.to, dist[nb.to]});
                    }
                }
            }
        }  
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        /**
                 />-------10------>-\
                0 --7---> 1 ---1----> 3
                 \----1--->2 ---9--->/
                            \
                             \---11---->4

                k = 0
                q = [,(3,8)] // [node, cost]
                front = 
                d = [0 7 1  8 ~]
                     0 1 2  3 4
         */      
    }

   
}