class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # -1 -1 0 1 2 4
        #       l
        #       r
        # 0 1 2
        nums.sort()
        n = len(nums)
        res = []
        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            find = -nums[i]
            l, r = i + 1, n - 1
            while l < r:
                if nums[l] + nums[r] == find:
                    res.append([nums[i], nums[l], nums[r]])
                    
                if nums[l] + nums[r] > find:
                    r -= 1
                    while l < r and nums[r] == nums[r + 1]:
                        r -= 1
                else:
                    l += 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1

        return res
