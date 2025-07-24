class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = nums[0]
        best, worse = nums[0], nums[0]
        prev_best, prev_worse = best, worse
        print(best, worse)
        for i in range(1, len(nums)):
            prev_best, prev_worse = best, worse
            if nums[i-1] == 0:
                best, worse = nums[i], nums[i]
            else:
                best = max(nums[i], nums[i] * prev_best, nums[i] * prev_worse)
                worse = min(nums[i], nums[i] * prev_best, nums[i] * prev_worse)
            res = max(res, best)
            print(best, worse)
        return res
