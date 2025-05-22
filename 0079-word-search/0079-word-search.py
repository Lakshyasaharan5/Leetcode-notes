class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        """
        mark
        dfs()
        unmark
        """

        def dfs(board, word, i, j, idx):
            if idx == len(word):
                return True
            if i<0 or j<0 or i>=len(board) or j>=len(board[0]) or board[i][j]!=word[idx]: 
                return False            
            save = board[i][j] #save current char before marking
            board[i][j] = '*'
            found = (
                    dfs(board, word, i+1, j, idx+1) or 
                    dfs(board, word, i, j+1, idx+1) or 
                    dfs(board, word, i-1, j, idx+1) or 
                    dfs(board, word, i, j-1, idx+1)
            )
            board[i][j] = save #unmark
            return found

        # Iterating over board to find first matching char of string
        for i in range(len(board)):
            for j in range(len(board[0])):
                # Start dfs
                if board[i][j] == word[0]:
                    if(dfs(board, word, i, j, 0)):
                        return True
        
        return False
