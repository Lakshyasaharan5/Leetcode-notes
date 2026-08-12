class Solution {
    Integer[][] dp;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        /**
                    [1,2,3]    target = 9
                    1    2    3
                  2  3   3
                 3

         */
        dp = new Integer[nums.size()][target + 1];
        int res = dfs(nums, target, 0);
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    private int dfs(List<Integer> nums, int target, int i) {
        if (target == 0) return 0;
        if (i >= nums.size() || target < 0) return Integer.MIN_VALUE;
        if (dp[i][target] != null) return dp[i][target];
        int take = dfs(nums, target - nums.get(i), i + 1);
        if (take != Integer.MIN_VALUE) take++;
        int skip = dfs(nums, target, i + 1);
        int res = Math.max(take, skip);
        return dp[i][target] = (res == Integer.MIN_VALUE ? Integer.MIN_VALUE : res);
    }
}