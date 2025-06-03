class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        islands = 0
        directions = [0, 1, 0, -1, 0]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    islands += 1

                    # stack dfs
                    stack = [(i, j)]
                    grid[i][j] = "0"
                    while stack:
                        pair = stack.pop()
                        for k in range(len(directions) - 1):
                            r, c = pair[0] + directions[k], pair[1] + directions[k + 1]
                            if (
                                r >= 0
                                and c >= 0
                                and r < m
                                and c < n
                                and grid[r][c] == "1"
                            ):
                                stack.append((r, c))
                                grid[r][c] = "0"

        return islands
