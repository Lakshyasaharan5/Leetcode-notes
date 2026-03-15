class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        """
                0 1 2 3 4 5 6 7
        nums = [4,2,2,2,4,4,2,2], limit = 0
                l
                r
        maxq = [0]
        minq = [0]
        longest = 0
        """
        n = len(nums)
        longest = 0
        maxq = deque([0])
        minq = deque([0])
        l, r = 0, 0
        while r < n:             
            #expand
            while maxq and nums[maxq[-1]] <= nums[r]:
                maxq.pop()
            maxq.append(r)
            while minq and nums[minq[-1]] >= nums[r]:
                minq.pop()
            minq.append(r)
            #shrink
            while abs(nums[maxq[0]] - nums[minq[0]]) > limit:
                l += 1
                if maxq[0] < l:
                    maxq.popleft()
                if minq[0] < l:
                    minq.popleft()
            #update longest
            longest = max(longest, r - l + 1)
            r += 1
        return longest
        