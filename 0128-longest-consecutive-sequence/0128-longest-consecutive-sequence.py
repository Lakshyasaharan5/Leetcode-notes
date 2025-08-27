class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)
        longest = 0
        for n in nums_set:
            if n - 1 in nums_set:
                continue
            curr = 0
            i = n
            while i in nums_set:
                curr += 1
                i += 1
            longest = max(longest, curr)

        return longest