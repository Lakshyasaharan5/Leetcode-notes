class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        N = len(questions)
        dp = [0] * N
        dp[-1] = questions[-1][0]
        for i in range(N - 2, -1, -1):
            next = i + questions[i][1] + 1             
            dp[i] = max(dp[i + 1], questions[i][0] + (dp[next] if next < N else 0))
        return dp[0]