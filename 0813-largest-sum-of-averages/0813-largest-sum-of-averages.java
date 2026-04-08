class Solution {
    Double[][] dp;
    public double largestSumOfAverages(int[] nums, int k) {
        dp = new Double[nums.length][k + 1];
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        return dfs(nums, 0, k, prefixSum);
    }

    private double dfs(int[] nums, int start, int k, int[] prefixSum) {
        int n = nums.length;        
        if (start == n) return 0;
        if (k == 1) {
            double currAvg = (prefixSum[n - 1] - (start > 0 ? prefixSum[start - 1] : 0)) / (double)(n - start);
            return currAvg;
        }
        if (dp[start][k] != null) return dp[start][k];
        double currRes = -1;
        for (int i = start; i < nums.length; i++) {
            double currAvg = (prefixSum[i] - (start > 0 ? prefixSum[start - 1] : 0)) / (double)(i - start + 1);
            currRes = Math.max(currRes, currAvg + dfs(nums, i + 1, k - 1, prefixSum));
        }
        return dp[start][k] = currRes;
    }
}