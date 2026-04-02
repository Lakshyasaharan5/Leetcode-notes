class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // [0,1],[0,2],[2,5],[3,4],[4,2]
        // 0 1 2 0 1 1 
        // 0 1 2 3 4 5
        int[] incoming = new int[n];
        for (List<Integer> edge : edges) {
            incoming[edge.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}