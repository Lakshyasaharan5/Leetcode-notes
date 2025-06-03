class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        cnt = 0

        def dfs(r, c):
            if r<0 or r==len(grid) or c<0 or c==len(grid[0]) or grid[r][c]!='1':
                return
            grid[r][c] = '0'
            dfs(r-1, c)
            dfs(r+1, c)
            dfs(r, c-1)
            dfs(r, c+1)    


        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    dfs(i, j)
                    cnt += 1

        return cnt
