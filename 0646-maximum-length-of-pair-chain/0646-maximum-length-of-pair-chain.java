class Solution {
    Integer[] dp;
    public int findLongestChain(int[][] pairs) {
        dp = new Integer[pairs.length];
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            res = Math.max(res, dfs(pairs, i));
        }
        return res;
    }

    private int dfs(int[][] pairs, int start) {
        if (start == pairs.length) return 0;
        if (dp[start] != null) return dp[start];
        int curr = Integer.MIN_VALUE;
        for (int i = start + 1; i < pairs.length; i++) {
            if (pairs[i][0] > pairs[start][1]) {
                curr = Math.max(curr, dfs(pairs, i));
            }
        }
        return dp[start] = (curr == Integer.MIN_VALUE ? 0 : curr) + 1;
    }
}