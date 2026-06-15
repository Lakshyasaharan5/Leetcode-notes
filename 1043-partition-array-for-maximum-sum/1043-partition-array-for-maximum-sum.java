class Solution {
    Integer[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return dfs(arr, k, 0);
    }

    private int dfs(int[] arr, int k, int start) {
        if (start == arr.length) return 0;
        if (dp[start] != null) return dp[start];
        int currRes = Integer.MIN_VALUE;
        int currMaxValue = arr[start];
        for (int i = start; i < Math.min(start + k, arr.length); i++) {
            currMaxValue = Math.max(currMaxValue, arr[i]);
            currRes = Math.max(currRes, currMaxValue * (i - start + 1) + dfs(arr, k, i + 1));
        }
        return dp[start] = currRes;
    }
}