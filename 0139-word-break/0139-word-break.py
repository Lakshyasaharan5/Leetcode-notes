class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        dp = [-1] * len(s)
        def dfs(s, start):
            if start >= len(s):
                return True  
            if dp[start] != -1:
                return True if dp[start] == 1 else False          
            found = False
            for i in range(start, len(s)):
                if s[start : i + 1] in wordSet:
                    if dfs(s, i + 1):
                        found = True
                        break
            
            dp[start] = 1 if found else 0
            return found

        return dfs(s, 0)
