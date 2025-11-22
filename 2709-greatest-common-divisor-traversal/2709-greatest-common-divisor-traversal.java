class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1)
            return true;
        DSU dsu = new DSU(nums.length);
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                return false;
            primeFactors(nums[i], i, dsu, mpp);
        }
        int cnt = 0;
        for(int i = 0; i < dsu.parent.length; i++) {
            if (i == dsu.parent[i]) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }

    private void primeFactors(int n, int idx, DSU dsu, HashMap<Integer, Integer> mpp) {
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                if (mpp.containsKey(i)) {
                    dsu.union(mpp.get(i), idx);
                } else {
                    mpp.put(i, idx);
                }
                while (n % i == 0) {
                    n = n / i;
                }
            }
            i++;
        }

        if (n > 1) {
            if (mpp.containsKey(n)) {
                dsu.union(mpp.get(n), idx);
            } else {
                mpp.put(n, idx);
            }
        }
    }
}

class DSU {
    int[] parent, rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB)
            return;

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // path compression
        return parent[x];
    }
}