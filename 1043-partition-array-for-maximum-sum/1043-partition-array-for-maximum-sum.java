class Solution {
    Integer[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return dfs(arr, 0, k);
    }

    private int dfs (int[] arr, int start, int k) {
        if (start == arr.length) return 0;
        if (dp[start] != null) return dp[start];
        int currMax = Integer.MIN_VALUE;
        int currRes = 0;
        for (int i = start; i < Math.min(start + k, arr.length); i++) {
            currMax = Math.max(currMax, arr[i]);
            currRes = Math.max(currRes, currMax * (i - start + 1) + dfs(arr, i + 1, k));
        }        
        return dp[start] = currRes;
    }
}