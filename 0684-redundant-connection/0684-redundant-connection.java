class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        /**
            1--2 
            | /
            3 

            1-2-3
             \|
              4
            [[1,2][2,3][2,4][1,4]] res=[1,4]
           0 1 2 3 4]
             1 2 3 4

            union(edge)
                if same parent 
                    return false
                return true
            n-1 edges -> tree
            n
        */

        int n = edges.length;
        int[] parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }
        for (int[] e : edges) {
            if (!union(parents, e)) {
                return e;
            }
        }
        return new int[]{-1, -1};
    }

    private int find(int[] parents, int x) {
        while (x != parents[x])
            x = parents[x];
        return x;
    }

    private boolean union(int[] parents, int[] e) {
        int u = e[0], v = e[1];
        int pu = find(parents, u);
        int pv = find(parents, v);
        if (pu == pv) return false;
        parents[pu] = pv;
        return true;
    }   
}