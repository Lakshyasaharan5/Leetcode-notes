class Solution {
    int components = 0;
    public int findCircleNum(int[][] isConnected) {
        //  1 2 3
        // [1,1,0] 1
        // [1,1,0] 2
        // [0,0,1] 3

        // [0, 1, 1, 3]
        int n = isConnected.length;
        this.components = n;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parent);
                }
            }
        }

        int p = 0;
        for (int i = 0; i < parent.length; i++) {
            if (find(i, parent) == i) p++;
        }
        return this.components;
    }

    /*
             4
             \ \
              1 2
               \
                 2
     */
    private int find(int node, int[] parent) {
        if (parent[node] == node) return node;
        parent[node] = find(parent[node], parent);
        return parent[node];
    }

    private void union(int u, int v, int[] parent) {
        int pu = find(u, parent);
        int pv = find(v, parent);
        if (pu == pv) return;
        parent[pu] = pv;
        this.components--;
    }
    
}