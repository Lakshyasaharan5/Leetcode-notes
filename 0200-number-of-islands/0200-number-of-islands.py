class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        islands = 0
        def bfs(r, c):
            que = deque()
            que.append((r,c))
            grid[r][c] = '0'
            while que:
                (fr, fc) = que.popleft()
                for dr, dc in [(1,0), (-1,0), (0,1), (0,-1)]:
                    nr = fr + dr
                    nc = fc + dc
                    if nr < 0 or nc < 0 or nr >= ROWS or nc >= COLS or grid[nr][nc] == '0':
                        continue
                    grid[nr][nc] = '0'
                    que.append((nr, nc))

        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == '1':
                    bfs(i, j)
                    islands += 1

        return islands

