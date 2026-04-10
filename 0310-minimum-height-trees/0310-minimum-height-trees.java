class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return new ArrayList<>(Arrays.asList(0));
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) { // O(V)
            graph.put(i, new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) { // O(E)
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) { // O(V)
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int processed = n;
        while (processed > 2) { // O(V + E)
            int currSize = queue.size();
            while (currSize-- > 0) {            
                int node = queue.poll();
                processed--;
                for (int neib : graph.get(node)) {
                    degree[neib]--;
                    if (degree[neib] == 1) {
                        queue.offer(neib);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }

        return res;
    }
}