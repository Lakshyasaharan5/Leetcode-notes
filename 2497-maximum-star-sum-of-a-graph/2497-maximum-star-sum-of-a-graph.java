class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }        
        int res = Integer.MIN_VALUE;
        for (int u = 0; u < n; u++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
            for (int v : graph.get(u)) {
                if (vals[v] >= 0)
                    pq.offer(vals[v]);
                if (pq.size() > k) pq.poll();
            }
            int curr = vals[u];
            while (!pq.isEmpty()) {
                curr += pq.poll();
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}