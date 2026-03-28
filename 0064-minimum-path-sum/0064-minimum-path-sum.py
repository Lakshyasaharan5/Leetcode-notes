class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        M = len(grid)
        N = len(grid[0])
        dp = [0] * N        
        for r in range(M - 1, -1, -1):
            for c in range(N - 1, -1, -1):
                if (c + 1) == N:
                    dp[c] = grid[r][c] + dp[c]
                elif (r + 1) == M:
                    dp[c] = grid[r][c] + dp[c + 1]
                else:
                    dp[c] = grid[r][c] + min(dp[c], dp[c + 1])

        return dp[0]