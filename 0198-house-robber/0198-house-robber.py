class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [-1] * (len(nums) + 1)

        def dfs(nums, dp, i):
            if i >= len(nums):
                return 0
            if dp[i] != -1: return dp[i]

            dp[i] = nums[i] + max(dfs(nums, dp, i+2), dfs(nums, dp, i+3))
            return dp[i]

        return max(dfs(nums, dp, 0), dfs(nums, dp, 1))