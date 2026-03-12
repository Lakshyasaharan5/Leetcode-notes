class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        smaller = 0
        equal = 0
        for n in nums:
            if n < pivot:
                smaller += 1
            elif n == pivot:
                equal += 1
        
        res = [0] * len(nums)
        l = 0
        m = smaller
        h = smaller + equal
        
        for n in nums:
            if n < pivot:
                res[l] = n
                l += 1
            elif n == pivot:
                res[m] = n
                m += 1
            else:
                res[h] = n
                h += 1
        
        return res