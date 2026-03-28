class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        ROWS = len(obstacleGrid)
        COLS = len(obstacleGrid[0])
        dp = {}
        @cache
        def dfs(r, c):
            if r < 0 or c < 0 or r >= ROWS or c >= COLS or obstacleGrid[r][c] == 1:
                return 0
            if r == ROWS - 1 and c == COLS - 1:
                return 1
            # if (r,c) in dp:
            #     return dp[(r,c)]
            dp[(r,c)] = dfs(r+1, c) + dfs(r, c+1)
            return dp[(r,c)]
        return dfs(0,0)