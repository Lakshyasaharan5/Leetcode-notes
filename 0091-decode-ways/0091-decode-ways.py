class Solution:
    def numDecodings(self, s: str) -> int: 
        dp = [-1] * len(s)       
        def dfs(s, i):
            if i >= len(s):
                return 1
            if s[i] == "0":
                return 0

            if dp[i] >= 0:
                return dp[i]

            left = dfs(s, i+1)

            right = 0
            if i+1 < len(s) and 10 <= int(s[i:i+2]) <= 26:
                right = dfs(s, i+2)

            dp[i] = left + right
            return dp[i]

        return dfs(s, 0)