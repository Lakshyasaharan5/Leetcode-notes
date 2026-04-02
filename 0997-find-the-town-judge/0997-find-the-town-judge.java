class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        Map<Integer, List<Integer>> incoming = new HashMap<>();
        Map<Integer, List<Integer>> outgoing = new HashMap<>();
        // a -> b
        for (int[] edge : trust) {
            int u = edge[0], v = edge[1];
            outgoing.computeIfAbsent(u, k -> new ArrayList<Integer>()).add(v);
            incoming.computeIfAbsent(v, k -> new ArrayList<Integer>()).add(u);
        }
        for (Map.Entry<Integer, List<Integer>> e : incoming.entrySet()) {
            if (e.getValue().size() == n - 1) {
                if (!outgoing.containsKey(e.getKey())) {
                    return e.getKey();
                }
            }
        }
        return -1;
    }
}