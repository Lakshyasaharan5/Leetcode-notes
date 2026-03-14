class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        N = len(nums)
        l, m = 0, 0
        r = N - 1
        while l <= m and m <= r:
            curr = nums[m]
            if curr == 0:
                nums[l], nums[m] = nums[m], nums[l]
                l += 1
                m = max(m, l)
            elif curr == 2:
                nums[r], nums[m] = nums[m], nums[r]
                r -= 1
                m = min(m, r)
            else:
                m += 1
        