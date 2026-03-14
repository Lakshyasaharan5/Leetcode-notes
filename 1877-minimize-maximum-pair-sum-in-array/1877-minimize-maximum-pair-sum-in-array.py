class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        maxsum = 0
        l, r = 0, len(nums) - 1       
        while l <= r:
            maxsum = max(maxsum, nums[l] + nums[r])
            l += 1
            r -= 1
        return maxsum