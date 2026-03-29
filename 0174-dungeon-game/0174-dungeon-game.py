class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        M, N = len(dungeon), len(dungeon[0])
        for i in range(M - 1, -1, -1):
            for j in range(N - 1, -1, -1):
                if i == M - 1 and j == N - 1:
                    continue
                if i + 1 < M and j + 1 < N:
                    need = max(dungeon[i + 1][j], dungeon[i][j + 1])                    
                elif i + 1 < M:
                    need = max(dungeon[i + 1][j], -2000)
                else:
                    need = max(-2000, dungeon[i][j + 1])
                if need < 0:
                    dungeon[i][j] += need


        return 1 if dungeon[0][0] >= 0 else (dungeon[0][0] * -1 + 1)