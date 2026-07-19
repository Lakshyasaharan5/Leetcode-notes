class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[src] = 0;
        while (k >= 0) {
            int[] t = new int[n];
            Arrays.fill(t, Integer.MAX_VALUE);
            t[src] = 0;
            for (int[] edge : flights) {
                int u = edge[0], v = edge[1], cost = edge[2];
                if (d[u] != Integer.MAX_VALUE) {
                    t[v] = Math.min(t[v], d[u] + cost);
                }
            }
            d = t;
            k--;
        }
         return d[dst] == Integer.MAX_VALUE ? -1 : d[dst];
    }
}