class Solution {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        dp = new Integer[nums.length][nums.length];
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int l, int r) {
        if (l > r) return 0;
        if (dp[l][r] != null) return dp[l][r];
        int curr = 0;
        for (int k = l; k <= r; k++)
            curr = Math.max(curr, (l > 0 ? nums[l - 1] : 1) * nums[k] * (r < nums.length - 1 ? nums[r + 1] : 1) + dfs(nums, l, k - 1) +  dfs(nums, k + 1, r));
        
        return dp[l][r] = curr;
    }
}