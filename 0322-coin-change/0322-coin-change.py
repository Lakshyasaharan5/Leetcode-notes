class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:        
        memo = {}

        def dfs(amount):
            if amount < 0:
                return float('inf')
            if amount == 0:
                return 0
            if amount in memo:
                return memo[amount]
            
            res = float('inf')
            for c in coins:
                res = min(dfs(amount - c) + 1, res)
            memo[amount] = res
            return res

        res = dfs(amount)
        return res if res != float('inf') else -1
