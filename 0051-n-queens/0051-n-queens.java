class Solution {
    /**
        . t . .
        . . . t
        . . . .
        . . . .

            t
        00 01 02 03
        10 11 12 13t
        20 21 22 23
        30 31 32 33

        rows = []
        i+j = []
        j-i = []

        top left to bottom right
        ii i,i+1, i,i+2, i,i+3
        i,i-1 i,i-2, i,i-3

        j-i = 0,1,2,3,

        top right to bottom left
        i+j=3
        i+j=2
        i+j=0
        i+j=4,5,6

        dfs(r, q):
            if (r == n && q == n):
                store in res
                return
            for (0 -> n):
                if (valid):
                    add
                    dfs(r + 1, q + 1)
                    remove


        [[".Q..",
          "...Q",
          "Q...",
          "..Q."],
         
         ["..Q.","Q...","...Q",".Q.."]]
     */

    private void dfs(int row, int n, boolean[][] board, Set<Integer> cols, Set<Integer> i_plus_j, Set<Integer> i_minus_j, List<List<String>> res) {

        if (row == n) {
            // store result
            List<String> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String currRow = "";
                for (int j = 0; j < n; j++) {
                    currRow += board[i][j] ? "Q" : ".";
                }
                curr.add(currRow);
            }
            res.add(curr);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!cols.contains(col) && !i_plus_j.contains(row+col) && !i_minus_j.contains(row-col)) {
                board[row][col] = true;
                cols.add(col);
                i_plus_j.add(row+col);
                i_minus_j.add(row-col);

                dfs(row + 1, n, board, cols, i_plus_j, i_minus_j, res);

                board[row][col] = false;
                cols.remove(col);
                i_plus_j.remove(row+col);
                i_minus_j.remove(row-col);
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {        
        List<List<String>> res = new ArrayList<>();
        dfs(0, n, new boolean[n][n], new HashSet<>(), new HashSet<>(), new HashSet<>(), res);
        return res;
    }
}