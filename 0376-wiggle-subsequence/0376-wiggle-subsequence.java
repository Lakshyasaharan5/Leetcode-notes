class Solution {
    Integer[][][] dp;

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        dp = new Integer[n + 1][n][2];

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, 1 + dfs(nums, i, i + 1, 1)); // expecting up
            res = Math.max(res, 1 + dfs(nums, i, i + 1, 0)); // expecting down
        }
        return res;
    }

    private int dfs(int[] nums, int prevIndex, int currIndex, int inc) {
        if (currIndex == nums.length) return 0;

        if (dp[prevIndex][currIndex][inc] != null) {
            return dp[prevIndex][currIndex][inc];
        }

        int take = 0;

        if ((inc == 1 && nums[currIndex] > nums[prevIndex]) ||
            (inc == 0 && nums[currIndex] < nums[prevIndex])) {
            
            take = 1 + dfs(nums, currIndex, currIndex + 1, 1 - inc);
        }

        int skip = dfs(nums, prevIndex, currIndex + 1, inc);

        return dp[prevIndex][currIndex][inc] = Math.max(take, skip);
    }
}