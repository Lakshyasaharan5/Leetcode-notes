class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        /**
            0 -> 1 -> 2   /-------->6
                  \----->3--->4
                7-->----/ \-->---->5
         */
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = quiet.length;
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : richer) {
            // [u,v] v->u
            graph.get(edge[1]).add(edge[0]);
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            if (res[i] != -1) continue;
            int curr = dfs(graph, i, quiet, res);
            res[i] = curr;
        }
        return res;
    }

    private int dfs(Map<Integer, List<Integer>> graph, int start, int[] quiet, int[] res) {    
        if (res[start] != -1) return res[start];
        int curr = quiet[start];
        int min_index = start;
        for (int nb : graph.get(start)) {
            int index = dfs(graph, nb, quiet, res);
            if (quiet[index] < curr) {
                curr = quiet[index];
                min_index = index;
            }
        }
        return res[start] = min_index;
    }
}