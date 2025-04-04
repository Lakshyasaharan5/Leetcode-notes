class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(nums, i):
            if i == len(nums):
                res.append(nums.copy())
                return

            for j in range(i, len(nums)):
                nums[j], nums[i] = nums[i], nums[j]
                dfs(nums, i+1)
                nums[j], nums[i] = nums[i], nums[j]
        
        dfs(nums, 0)
        return res