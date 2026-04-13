class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int k : nums) total += k;
        int target = total / 2;
        if (total % 2 != 0) return false;
        Arrays.sort(nums);        
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];
        dp[n - 1][0] = true;
        if (nums[n - 1] <= target) dp[n - 1][nums[n - 1]] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = target; j >= 0; j--) {
                dp[i][j] |= dp[i + 1][j];
                if (j - nums[i] >= 0)
                    dp[i][j] |= dp[i + 1][j - nums[i]];
            }
        }     
        return dp[0][target];   
    }
}