class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # max heap with atmost k elements
        maxheap = []
        for p in points:
            x,y = p[0],p[1]
            distance = (x*x + y*y)
            heappush(maxheap, [-distance, p]) 
            if len(maxheap) > k:
                heappop(maxheap)
        res = []
        while maxheap:
            res.append(heappop(maxheap)[1])
        return res