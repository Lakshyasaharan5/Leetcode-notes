class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [-1] * len(nums)
        def dfs(start):
            if start >= len(nums):
                return 0
            if dp[start] != -1:
                return dp[start]
            curr = nums[start]
            res = float('-inf')
            for i in range(start+1, len(nums)):
                if nums[i] > curr:
                    res = max(dfs(i), res)
            dp[start] = 0 if res == float('-inf') else res + 1
            return dp[start]

        res = float('-inf')
        for i in range(len(nums)):
            res = max(dfs(i), res)
        return res + 1