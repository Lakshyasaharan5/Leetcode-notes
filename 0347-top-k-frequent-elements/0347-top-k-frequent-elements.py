class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for num in nums:
            if num in freq:
                freq[num] += 1
            else:
                freq[num] = 1
        
        bucket = [[] for _ in range(len(nums)+1)]

        for key in freq.keys():
            bucket[freq[key]].append(key)

        res = []
        for i in range(len(nums), -1, -1):
            if len(bucket[i]) > 0:
                for item in bucket[i]:
                    k -= 1
                    res.append(item)
                    if(k==0): 
                        return res

        return res


