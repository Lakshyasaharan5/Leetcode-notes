class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [-1] * len(nums)
        def dfs(idx):
            if idx >= len(nums): return 0
            if dp[idx] != -1: return dp[idx]
            dp[idx] = max(dfs(idx + 2), dfs(idx + 3)) + nums[idx]
            return dp[idx]
        return max(dfs(0), dfs(1))

