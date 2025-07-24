class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s) + 1)
        dp[-1] = True
        wordSet = set(wordDict)
        for i in range(len(s) - 1, -1, -1):
            for j in range(i, len(s)):
                if s[i : j+1] in wordSet:
                    if dp[j + 1]:
                        dp[i] = True
        return dp[0]