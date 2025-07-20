class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        dp = [-1] * (len(nums) + 1)
        def dfs(i):
            if i >= len(nums):
                return 0
            
            if dp[i] != -1:
                return dp[i]

            dp[i] = max(dfs(i+2), dfs(i+3)) + nums[i]

            return dp[i]

        return max(dfs(0), dfs(1))

            