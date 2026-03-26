class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        currMax = neededTime[0]
        total = 0
        for i in range(1, len(colors)):
            if colors[i] == colors[i - 1]:
                if neededTime[i] >= currMax:
                    total += currMax
                    currMax = neededTime[i]
                else:
                    total += neededTime[i]
            else:
                currMax = neededTime[i]
        return total