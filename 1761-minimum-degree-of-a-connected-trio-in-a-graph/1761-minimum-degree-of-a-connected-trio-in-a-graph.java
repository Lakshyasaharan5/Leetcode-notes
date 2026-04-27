class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int[][] matrix = new int[n][n];
        Map<Integer, List<Integer>> list = new HashMap<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            list.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = --edge[0], v = --edge[1];
            degree[u]++;
            degree[v]++;
            list.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            list.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> neib = list.get(i);
            for (int j = 0; j < neib.size(); j++) {
                for (int k = j + 1; k < neib.size(); k++) {
                    int a = i, b = neib.get(j), c = neib.get(k);
                    if (matrix[b][c] == 1) {
                        res = Math.min(res, degree[a] + degree[b] + degree[c] - 6);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}