class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        if s[-1] == '1':
            return False
        n = len(s)
        dp = [False] * n
        dp[-1] = True
        counter = 0
        for i in range(n - 2, -1, -1):
            if i + minJump < n and dp[i + minJump]:
                counter += 1

            if i + maxJump + 1 < n and dp[i + maxJump + 1]:
                counter -= 1

            if s[i] == '0' and counter > 0:
                dp[i] = True

        return dp[0]
        