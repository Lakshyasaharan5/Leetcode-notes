class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # max heap with atmost k elements
        maxheap = []
        for i in range(len(points)):
            x,y = points[i][0],points[i][1]
            distance = (x*x + y*y)
            heappush(maxheap, [-distance, i]) 
            if len(maxheap) > k:
                heappop(maxheap)
        res = []
        while maxheap:
            res.append(points[heappop(maxheap)[1]])
        return res