class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        dp[-1] = 1
        res = float('-inf')
        for i in range(len(nums) - 1, -1, -1):
            curr = float('-inf')
            for j in range(i + 1, len(nums)):
                if nums[j] > nums[i]:
                    curr = max(curr, dp[j])
            dp[i] = 1 if curr == float('-inf') else curr + 1
            res = max(res, dp[i])

        return res