class Solution:
    def tribonacci(self, n: int) -> int:
        if n < 2:
            return n
        if n == 2:
            return 1
        a, b, c = 0, 1, 1
        curr = 0
        for _ in range(3, n + 1):
            curr = a + b + c
            a = b
            b = c
            c = curr
        return curr