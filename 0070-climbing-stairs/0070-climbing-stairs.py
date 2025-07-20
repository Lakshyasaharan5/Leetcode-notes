class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0] * (n + 1)

        def dfs(n):
            if n <= 3:
                return n
            if dp[n] != 0:
                return dp[n]

            dp[n] = dfs(n - 1) + dfs(n - 2)
            return dp[n]

        return dfs(n)
