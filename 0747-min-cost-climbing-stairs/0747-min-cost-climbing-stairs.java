class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(solve(cost, dp, 0), dp[1]);
    }

    int solve(int[] cost, int[] dp, int i){
        if(i >= cost.length){
            return 0;
        }
        if(dp[i] != -1)
            return dp[i];
        dp[i] = cost[i] + Math.min(solve(cost, dp, i+1), solve(cost, dp, i+2));
        return dp[i];
    }
}