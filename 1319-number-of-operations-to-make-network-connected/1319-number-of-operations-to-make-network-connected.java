class Solution {
    int components = 0;
    public int makeConnected(int n, int[][] connections) {
        int cables = connections.length;
        int extra = cables - (n - 1);
        if (extra < 0) return -1;
        int[] parents = new int[n]; 
        for (int i = 0; i < n; i++) parents[i] = i;
        components = n;       
        for (int[] c : connections) {
            union(parents, c[0], c[1]);
        }
        return components - 1;
    }

    private void union(int[] parents, int u, int v) {
        int pu = find(parents, u);
        int pv = find(parents, v);
        if (pu == pv) return;
        components--;
        parents[pv] = pu;
    }

    private int find(int[] parents, int u) {
        while (parents[u] != u) u = parents[u];
        return u;
    }
}