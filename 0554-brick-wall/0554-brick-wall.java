class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edges = new HashMap<>();
        int maxEdge = 0;
        for (List<Integer> w : wall) {
            int curr = 0;
            for (int i = 0; i < w.size() - 1; i++) {                
                curr += w.get(i);
                edges.put(curr, edges.getOrDefault(curr, 0) + 1);
                maxEdge = Math.max(maxEdge, edges.get(curr));
            }
        }                
        return wall.size() - maxEdge;
    }
}