class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:        
        M, N = len(matrix), len(matrix[0])
        for i in range(M):
            for j in range(N):
                matrix[i][j] = int(matrix[i][j])
        largest_square = 0
        for i in range(M - 1, -1, -1):
            for j in range(N - 1, -1, -1):
                if matrix[i][j] == 0:
                    continue
                min_sq = float('inf')
                for dr, dc in [(1,0), (0,1), (1,1)]:
                    nr, nc = i + dr, j + dc
                    if nr >= M or nc >= N:
                        min_sq = min(min_sq, 0)
                    else:
                        min_sq = min(min_sq, matrix[nr][nc])
                matrix[i][j] = min_sq + 1
                largest_square = max(largest_square, matrix[i][j])

        return largest_square * largest_square
                