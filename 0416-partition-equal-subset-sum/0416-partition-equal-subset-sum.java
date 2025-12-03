class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums)
            total += n;
        if (total % 2 != 0 || nums.length == 1)
            return false;
        // Arrays.sort(nums);
        dp = new Boolean[nums.length + 1][total/2 + 1];
        return dfs(nums, total / 2, 0);
    }

    private boolean dfs(int[] nums, int target, int start) {
        if (target == 0){
            return true;
        }
        if (start >= nums.length)
            return false;     
        
        if (dp[start][target] != null) return dp[start][target];
        boolean curr = false;
        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] < 0)
                continue;
            curr |= dfs(nums, target - nums[i], i + 1);
        }
        dp[start][target] = curr;
        return curr;
    }
}