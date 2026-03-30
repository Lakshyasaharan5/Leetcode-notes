class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (destination == node) {
                return true;
            }
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)){                
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }
}