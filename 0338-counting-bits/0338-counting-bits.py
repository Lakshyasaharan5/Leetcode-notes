class Solution:
    def countBits(self, n: int) -> List[int]:
        # 0 --> 0
        # 1 --> 1
        # 2 --> 10
        # 3 --> 11
        # 4 --> 100
        # 5 --> 101
        # 6 --> 110
        # 7 --> 111
        # 8 --> 1000

        if n == 0:
            return [0]
        
        if n == 1:
            return [0,1]

        res = [0] * (n + 1)
        res[1] = 1

        offset = 1
        for i in range(2, n + 1):
            if i & (i-1) == 0:
                offset *= 2
            res[i] = res[i - offset] + 1

        return res

        
    