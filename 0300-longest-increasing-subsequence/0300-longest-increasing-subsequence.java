class Solution {
    /**
        0,1,0,3,2,3
         0
        1   3 2 3
      3 2 3
        3
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i, dp));
        }
        return res;
    }

    private int dfs(int[] nums, int start, int[] dp) {
        if (start >= nums.length) return 0;
        if (dp[start] != -1) return dp[start];
        int longest = 0;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] > nums[start]) {
                longest = Math.max(longest, dfs(nums, i, dp));
            }
        }
        return dp[start] = longest + 1;
    }
}