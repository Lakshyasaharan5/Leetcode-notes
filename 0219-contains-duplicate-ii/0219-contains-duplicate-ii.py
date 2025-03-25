class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # 1,2,3,1,2,3
        #     i---j

        freq = {}
        if k==0: return False
        i, j = 0, 0
        while j < len(nums):
            if nums[j] in freq:
                return True
            if j - i >= k:
                freq.pop(nums[i])
                i += 1
            freq[nums[j]] = 1
            j += 1

        return False