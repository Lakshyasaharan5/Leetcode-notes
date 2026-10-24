class Solution {
    /**

            board = [["X",".",".","X"],
                     [".",".",".","X"],
                     ["X","X",".","X"]]
     */
    public int countBattleships(char[][] board) {
        int ships = 0;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    ships++;
                    // right
                    if (j < n - 1 && board[i][j + 1] == 'X') {
                        int r = j;
                        while (r < n && board[i][r] == 'X') {
                            board[i][r] = '.';
                            r++;
                        }
                    } else {
                        // down
                        int d = i;
                        while (d < m && board[d][j] == 'X') {
                            board[d][j] = '.';
                            d++;
                        }
                    }                                        
                }
            }
        }
        return ships;
    }
}