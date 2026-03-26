class Solution:
    def numSquares(self, n: int) -> int:
        dp = [n] * (n + 1)
        dp[0] = 0
        for i in range(1, n + 1):
            curr = i
            for j in range(1, i):
                if i - j * j < 0:
                    break
                curr = min(curr, dp[i - j * j] + 1)
            dp[i] = curr
        return dp[n]