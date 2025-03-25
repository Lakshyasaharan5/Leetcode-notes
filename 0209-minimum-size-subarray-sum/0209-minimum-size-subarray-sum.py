class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        i, j = 0, 0
        currSum = 0
        res = float("inf")
        while j < len(nums):
            currSum += nums[j]
            while currSum >= target:
                res = min(res, j - i + 1)
                currSum -= nums[i]
                i += 1
            j += 1
        return 0 if res == float("inf") else res
