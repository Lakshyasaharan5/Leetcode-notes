class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l, h = i + 1, len(nums) - 1
            complement = -1 * nums[i]
            while l < h:
                if nums[l] + nums[h] == complement:
                    res.append([nums[i], nums[l], nums[h]])
                    l += 1
                    h -= 1
                    while l < h and nums[l] == nums[l - 1]:
                        l += 1
                    while l < h and nums[h] == nums[h + 1]:
                        h -= 1
                elif nums[l] + nums[h] > complement:
                    h -= 1
                else:
                    l += 1
        
        return res
