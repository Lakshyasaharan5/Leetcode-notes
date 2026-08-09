class Solution {
    Boolean[] dp;
    public boolean validPartition(int[] nums) {
        /**
                 0 1 2 3 4 5
                [4,4,4,5,6,2,2,2]
                 ^
                [1,3,6]
                   ^ 
                [4,4,4,4,4]
                         ^
         */
        dp = new Boolean[nums.length];
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int start) {
        /*
                 s
                 0 1 2 3 4 5 6 7
                [4,4,4,5,5,2,2,2]
                             i
        */
        if (start == nums.length) return true;
        if (start == nums.length - 1) return false;
        if (start == nums.length - 2) {
            return nums[start] == nums[start + 1];
        }
        if (dp[start] != null) return dp[start];
        boolean res = false;
        if (nums[start] == nums[start + 1]) {
            res |= dfs(nums, start + 2);
        }
        if (nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2]) {
            res |= dfs(nums, start + 3);
        }
        if (nums[start] + 1 == nums[start + 1] && nums[start + 1] + 1 == nums[start + 2]) {
            res |= dfs(nums, start + 3);
        }
        return dp[start] = res;
    }
}