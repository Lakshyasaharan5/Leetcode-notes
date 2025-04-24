class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # 7,2,5,1,6,4
        l, h = 0, 0
        res = float("-inf")
        while h < len(prices):
            res = max(res, prices[h] - prices[l])
            h += 1
            if h<len(prices) and prices[h] < prices[l]:
                l = h
        return res
