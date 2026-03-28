class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0] * len(days)
        dp[-1] = min(costs)
        for i in range(len(days) - 2, -1, -1):
            # 1 day pass
            dp[i] = costs[0] + dp[i + 1]

            # check 7 days pass
            idx = self.binary_search(days, i + 1, days[i] + 7) 
            dp[i] = min(dp[i], costs[1] + (dp[idx] if idx != -1 else 0))

            # check 30 days pass
            idx = self.binary_search(days, i + 1, days[i] + 30)
            dp[i] = min(dp[i], costs[2] + (dp[idx] if idx != -1 else 0))

        return dp[0]

    def binary_search(self, days, start, target):
        l, r = start, len(days) - 1
        while l < r:
            m = (l + r) // 2
            if days[m] < target:
                l = m + 1
            else:
                r = m
        if days[l] < target:
            return -1
        return l