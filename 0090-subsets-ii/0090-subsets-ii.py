class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = [[]]

        def dfs(nums, subset, i):
            if i == len(nums):
                return
            for j in range(i, len(nums)):
                if j>i and nums[j] == nums[j-1]:
                    continue
                subset.append(nums[j])
                res.append(subset.copy())
                dfs(nums, subset, j+1)
                subset.pop()

        dfs(sorted(nums), [], 0)
        return res

