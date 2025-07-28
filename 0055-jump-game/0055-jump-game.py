class Solution:
    def canJump(self, nums: List[int]) -> bool:
        maxReach = nums[0]
        for i in range(len(nums)):
            maxReach = max(maxReach, i + nums[i])
            if maxReach >= len(nums) - 1:
                return True
            if nums[i] == 0 and maxReach == i:
                return False            
        return False