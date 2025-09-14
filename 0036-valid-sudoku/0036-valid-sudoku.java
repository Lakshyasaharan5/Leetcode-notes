class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows and cols
        for(int i=0; i<9; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            for(int j=0; j<9; j++){   
                if(board[i][j] != '.'){
                    if (rows.contains(board[i][j])) return false;
                    rows.add(board[i][j]);
                }
                if(board[j][i] != '.'){
                    if (cols.contains(board[j][i])) return false;
                    cols.add(board[j][i]);
                }
            }
        }

        // box
        for(int i=0; i<=6; i+=3){
            for(int j=0; j<=6; j+=3){
                HashSet<Character> box = new HashSet<>();
                for(int m=i; m<i+3; m++){
                    for(int n=j; n<j+3; n++){
                        if (board[m][n] == '.') continue;
                        if (box.contains(board[m][n])) return false;
                        box.add(board[m][n]);
                    }
                }
            }
        }

        return true;
    }
}