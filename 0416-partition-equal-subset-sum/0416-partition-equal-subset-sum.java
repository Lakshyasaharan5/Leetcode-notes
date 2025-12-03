class Solution {
    Boolean[][] dp = new Boolean[201][20001];
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        if(total % 2 != 0) return false; // if total is odd, can't partition
        return backtrack(nums, 0, total/2);
    }

    private boolean backtrack(int[] nums, int start, int target) {
        if (target == 0) return true;
        if (start == nums.length || target < 0) return false;
        if (dp[start][target] != null) return dp[start][target];
        boolean curr = false;
        for (int i = start; i < nums.length; i++) {
            curr |= backtrack(nums, i + 1, target - nums[i]);
        }
        return dp[start][target] = curr;
    }
}