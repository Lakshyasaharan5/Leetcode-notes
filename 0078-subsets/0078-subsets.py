class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(nums, i, subset):
            if i == len(nums):
                res.append(subset.copy())
                return
            
            subset.append(nums[i])
            dfs(nums, i+1, subset)
            subset.pop()
            dfs(nums, i+1, subset)

        dfs(nums, 0, [])
        return res