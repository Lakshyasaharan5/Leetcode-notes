class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            indegree[v]++;
            graph.get(u).add(v);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        Map<Integer, Set<Integer>> ancestors = new HashMap<>();
        for (int i = 0; i < n; i++) ancestors.put(i, new HashSet<>());

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                ancestors.get(next).add(curr);
                ancestors.get(next).addAll(ancestors.get(curr));
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> curr = new ArrayList<>(ancestors.get(i));
            curr.sort((a,b) -> a - b);
            res.add(curr);
        }
        return res;
    }
}