class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int currMax = -1;
            for (int j = i; j < Math.min(i + k, n); j++) {
                currMax = Math.max(currMax, arr[j]);
                dp[i] = Math.max(dp[i], currMax * (j - i + 1) + dp[j + 1]);
            }
        }
        return dp[0];
    }
}