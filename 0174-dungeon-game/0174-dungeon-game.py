class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        M, N = len(dungeon), len(dungeon[0])
        dp = {}
        def dfs(i, j):
            if i >= M or j >= N:
                return -2000
            if (i, j) in dp:
                return dp[(i, j)]
            if i == M - 1 and j == N - 1:
                return dungeon[i][j]
            down = dfs(i + 1, j)
            right = dfs(i, j + 1)
            curr = max(down, right) 
            if curr >= 0:
                curr = 0
            dp[(i, j)] = curr + dungeon[i][j]            
            return dp[(i, j)]
        power_needed = dfs(0, 0) 
        if power_needed >= 0:
            return 1
        return power_needed * -1 + 1
            