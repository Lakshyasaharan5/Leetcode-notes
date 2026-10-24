class Solution {
    /**
            00  01   
            10  11 
    
            right
            down
            left
            up 
            
            Input: board = 
            [["A*,"B","C","E"],
             ["B","F","C","S"],
             ["A","D","E","E"]], 
    
            word = "ABCCED"
                    w
            Output: true
    
            dfs():
                for dir
                    if (dfs):
                        return true
                return false
    
     */
    private static final int[][] DIR = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int w) {
        if (w == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r == board.length || c == board[0].length
                || board[r][c] == '*' || board[r][c] != word.charAt(w)) {
            return false;
        }
        char currBoardChar = board[r][c];
        board[r][c] = '*';
        for (int[] d : DIR) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (dfs(board, nr, nc, word, w + 1)) {
                return true;
            }
        }
        board[r][c] = currBoardChar;
        return false;
    }
}