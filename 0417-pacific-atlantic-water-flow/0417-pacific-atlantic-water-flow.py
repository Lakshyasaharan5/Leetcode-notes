class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows, cols = len(heights), len(heights[0])
        visited = [[False for _ in range(cols)] for _ in range(rows)]        
        directions = [(1, 0), (0, 1), (0, -1), (-1, 0)]
        res = []

        def bfs(r, c):
            q = deque([(r, c)])
            visited[r][c] = True

            while q:
                cr, cc = q.popleft()
                if pacific_visited[cr][cc]:
                    res.append((cr,cc))
                for dr, dc in directions:
                    nr, nc = cr + dr, cc + dc
                    if (
                        0 <= nr < rows
                        and 0 <= nc < cols
                        and not visited[nr][nc]
                        and heights[nr][nc] >= heights[cr][cc]
                    ):
                        visited[nr][nc] = True
                        q.append((nr, nc))

            return False

        # check pacific side
        pacific_visited = [[False for _ in range(cols)] for _ in range(rows)]
        for c in range(0, cols):
            if not visited[0][c]:
                bfs(0, c)

        for r in range(0, rows):
            if not visited[r][0]:
                bfs(r, 0)

        pacific_visited = [row[:] for row in visited]
        visited = [[False for _ in range(cols)] for _ in range(rows)]
        # check atlantic side
        for c in range(0, cols):
            if not visited[rows - 1][c]:
                bfs(rows - 1, c)

        for r in range(0, rows):
            if not visited[r][cols - 1]:
                bfs(r, cols - 1)

        return res