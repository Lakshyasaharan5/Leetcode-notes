class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        res = 0
        directions = [1, 0, -1, 0, 1]
        def bfs(r,c):
            q = deque()
            q.append((r,c))
            area = 0
            while q:
                curr_r, curr_c = q.popleft()
                for i in range(1, len(directions)):
                    new_r, new_c = curr_r + directions[i-1], curr_c + directions[i]
                    if new_r < 0 or new_c < 0 or new_r >= len(grid) or new_c >= len(grid[0]) or grid[new_r][new_c] == 0:
                        continue
                    q.append((new_r, new_c))
                    grid[new_r][new_c] = 0
                    area += 1

            return 1 if area==0 else area


        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    area = bfs(i,j)
                    res = max(area, res)

        return res



