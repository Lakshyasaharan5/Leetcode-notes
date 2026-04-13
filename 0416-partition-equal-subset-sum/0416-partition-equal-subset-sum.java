class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) total += n;
        if (total % 2 != 0) return false;
        dp = new Boolean[nums.length][(total / 2) + 1];
        return dfs(nums, total / 2, 0);
    }

    private boolean dfs(int[] nums, int target, int i) {
        if (i >= nums.length || target < 0) return false;
        if (target == 0) return true;
        if (dp[i][target] != null) return dp[i][target];
        return dp[i][target] = dfs(nums, target - nums[i], i + 1) || dfs(nums, target, i + 1);
    }
}