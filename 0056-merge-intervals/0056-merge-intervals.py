class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda x : (x[0], x[1]))
        res = []
        i = 1
        start = intervals[0][0]
        end = intervals[0][1]
        while i < len(intervals):
            if intervals[i][0] > end:
                res.append([start, end])
                start = intervals[i][0]
                end = intervals[i][1]
            else:
                end = max(end, intervals[i][1])                
            i += 1

        res.append([start, end])

        return res
