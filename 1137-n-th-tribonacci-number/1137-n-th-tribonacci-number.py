class Solution:
    def tribonacci(self, n: int) -> int:
        dp = {}
        dp[0] = 0
        dp[1] = 1
        dp[2] = 1
        def dfs(n):
            if n in dp:
                return dp[n]
            dp[n] = dfs(n - 1) + dfs(n - 2) + dfs(n - 3)
            return dp[n]
        return dfs(n)