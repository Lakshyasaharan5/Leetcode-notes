class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [([-1]*n) for _ in range(m)]        
        def dfs(i, j, m, n):
            if i < 0 or j < 0 or i >= m or j >= n:
                return 0
            if dp[i][j] != -1:
                return dp[i][j]
            if i == m - 1 and j == n - 1:
                return 1
            dp[i][j] = dfs(i, j + 1, m, n) + dfs(i + 1, j, m, n)
            return dp[i][j]

        return dfs(0, 0, m, n)