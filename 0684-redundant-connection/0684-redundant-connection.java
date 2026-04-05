class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        int[] cycle = new int[2];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (!union(u, v, parent)) {
                cycle = edge;
                break;
            }
        }
        return cycle;
    }

    private int find(int node, int[] parent) {
        while (node != parent[node])
            node = parent[node];
        return node;
    }

    private boolean union(int u, int v, int[] parent) {
        int pu = find(u, parent);
        int pv = find(v, parent);
        if (pu == pv) return false;
        parent[pv] = pu;
        return true;
    }


}