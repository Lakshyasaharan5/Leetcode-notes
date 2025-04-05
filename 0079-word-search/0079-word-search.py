class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:        
        def dfs(board, i, j, word, itr):
            if itr == len(word):
                return True
            if i == len(board) or j == len(board[0]) or i < 0 or j < 0:
                return False            
            if board[i][j] != word[itr]:
                return False
            board[i][j]='*'
            res = dfs(board, i+1, j, word, itr+1) or dfs(board, i-1, j, word, itr+1) or dfs(board, i, j+1, word, itr+1) or dfs(board, i, j-1, word, itr+1)
            board[i][j]=word[itr]
            return res
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if dfs(board, i, j, word, 0):
                        return True

        return False
            