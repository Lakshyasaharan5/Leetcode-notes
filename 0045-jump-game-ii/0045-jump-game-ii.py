class Solution:
    def jump(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] == 0:
                dp[i] = float('inf')
                continue
            min_jumps = float('inf')
            for j in range(1, nums[i] + 1):
                if (i + j) >= (len(nums) - 1):
                    min_jumps = 0
                    break
                min_jumps = min(min_jumps, dp[i+j])
            dp[i] = min_jumps + 1
        return dp[0]

