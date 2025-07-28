class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        return solve(nums, 0, dp);
    }

    boolean solve(int[] nums, int start, int[] dp){
        if (start >= nums.length - 1){
            return true;
        }
        if (dp[start] != 0){
            return dp[start] == 1 ? true : false;
        }
        if (nums[start] == 0){
            return false;
        }
        for(int i=1; i<=nums[start]; i++){
            if (solve(nums, start + i, dp) == true){
                dp[start] = 1;
                return true;
            }
        }
        dp[start] = -1;
        return false;
    }
}