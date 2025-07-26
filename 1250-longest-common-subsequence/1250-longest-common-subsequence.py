class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = [[-1]*len(text2) for _ in range(len(text1))]

        def dfs(text1, text2, t1, t2):
            if t1 >= len(text1) or t2 >= len(text2):
                return 0
            if dp[t1][t2] != -1:
                return dp[t1][t2]
            res = 0
            if text1[t1] == text2[t2]:
                res = dfs(text1, text2, t1 + 1, t2 + 1) + 1
            else:
                res = max(dfs(text1, text2, t1 + 1, t2), 
                            dfs(text1, text2, t1, t2 + 1))
            dp[t1][t2] = res
            return res

        return dfs(text1, text2, 0, 0)
            