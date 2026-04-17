class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        if ((target + sum) % 2 > 0 || target > sum || target < -1 * sum) return 0;
        int newTarget = (target + sum) / 2;
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = newTarget; j >= 0; j--) {
                if (j - nums[i] >= 0)
                    dp[j] += dp[j - nums[i]];
            }
        }
        return dp[newTarget];
    }
}