class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = (max == Integer.MIN_VALUE ? 1 : max + 1);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}