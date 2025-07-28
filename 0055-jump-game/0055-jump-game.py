class Solution:
    def canJump(self, nums: List[int]) -> bool:
        dp = [False] * len(nums)
        dp[-1] = True
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] == 0:
                dp[i] = False
                continue
            for j in range(1, nums[i] + 1):
                if dp[i + j]:
                    dp[i] = True
                    break

        return dp[0]