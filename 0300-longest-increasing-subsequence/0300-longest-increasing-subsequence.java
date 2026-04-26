class Solution {
    Integer[] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i));
        }
        return res;
    }

    private int dfs(int[] nums, int start) {
        if (start == nums.length) return 0;
        if (dp[start] != null) return dp[start];
        int curr = Integer.MIN_VALUE;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] > nums[start]) {
                curr = Math.max(curr, dfs(nums, i));
            }
        }        
        return dp[start] = (curr == Integer.MIN_VALUE ? 0 : curr) + 1;
    }
}