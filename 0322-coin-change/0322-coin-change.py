class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        dp = [0] * (amount + 1)
        for i in range(1, len(dp)):
            curr = float('inf')
            for c in coins:
                if i >= c:
                    curr = min(curr, dp[i-c] + 1)
            dp[i] = curr

        return dp[amount] if dp[amount] != float('inf') else -1
                     