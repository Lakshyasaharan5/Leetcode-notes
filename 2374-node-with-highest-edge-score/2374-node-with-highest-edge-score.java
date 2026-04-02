class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] incoming = new long[n];
        for (int i = 0; i < n; i++) {
            incoming[edges[i]] += i;
        }
        int res = 0;
        long maxScore = 0;
        for (int i = 0; i < n; i++) {
            if (incoming[i] > maxScore) {
                maxScore = incoming[i];
                res = i;
            }
        }
        return res;
    }
}