class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        freq = {}
        for num in nums:
            if num in freq:
                freq[num] += 1
            else:
                freq[num] = 1

        buckets = [[] for _ in range(n + 1)]
        
        for key,val in freq.items():
            buckets[val].append(key)

        print(buckets)
        res = []
        for i in range(n, -1, -1):
            for item in buckets[i]:
                res.append(item)
                k -= 1
            if k == 0:
                break

        return res
