class Solution {
    public int combinationSum4(int[] nums, int target) {
        /**
            1, 2, 3
           1   2    3
        1 2 3  2 3    3

                 [1,2]               target=2
            /           \
          1,1           2,0
        1,0   2,-1

                ways = 0
                for i in (0 to n)
                    ways += dfs(target - a[i])
                return ways
         */
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return dfs(nums, target, dp);
    }

    private int dfs(int[] nums, int target, int[] dp) {
        if (target == 0) return 1;
        if (dp[target] != -1) return dp[target];
        int ways = 0;
        for (int n : nums) {
            if (target >= n) {
                ways += dfs(nums, target - n, dp);
            }
        }
        return dp[target] = ways;
    }
}