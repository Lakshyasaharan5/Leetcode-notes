class Solution {
    /**
        1 ------>3---->4
        2 -------^
         \-------->6

         max(1,2)
         
        1--->1---->1--->1
         \----->3--^

         
     */
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }        
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);            
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] == -1) {
                dfs(graph, i, dp, time);
            }
            maxTime = Math.max(maxTime, dp[i]);
        }
        return maxTime;
    }

    private int dfs(Map<Integer, List<Integer>> graph, int node, int[] dp, int[] time) {
        if (dp[node] != -1) {
            return dp[node];
        }
        int maxTime = 0;
        for (int nb : graph.get(node)) {
            maxTime = Math.max(maxTime, dfs(graph, nb, dp, time));
        }
        dp[node] = maxTime + time[node - 1];
        return dp[node];
    }
}