class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        dp = [-1] * (len(cost)+1)
        
        def dfs(cost, i):
            if i >= len(cost):
                return 0
            if dp[i] != -1:
                return dp[i]
            dp[i] = cost[i] + min(dfs(cost, i+1), dfs(cost, i+2))
            return dp[i]

        res = dfs(cost, 0)
        return min(res, dp[1])