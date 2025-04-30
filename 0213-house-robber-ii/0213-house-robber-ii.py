class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]
        def house_robber1(n):
            if len(n) == 0: return 0
            if len(n) == 1: return n[0]
            if len(n) == 2: return max(n[0], n[1])
            if len(n) == 3: return max(n[1], n[0]+n[2])
            n[2] += n[0]
            for i in range(3, len(n)):
                n[i] += max(n[i-2], n[i-3])
            return max(n[-1], n[-2])
        return max(house_robber1(nums[1:]), house_robber1(nums[:-1]))
        
