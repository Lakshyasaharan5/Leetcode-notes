class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // 00 01 02 03 ..... 08
        // 10 11 12 ...      18
        // .
        // .
        // .
        // 80 81 82 83 ..... 88

        // 00 -> column: 0,0-8    row: 0-8,0
        // 11 -> column: 1,0-8    row: 0-8,1
        // 22 -> column: 2,0-8    row: 0-8,2
        // .
        // .    
        // 88 -> column: 8,0-8    row: 0-8,8

        //  0 1 2 3 4 5 6 7 8
        // [0,0,0,1,0,1,0,0,0]        

        int[] rowFreq = null;
        int[] colFreq = null;

        for(int i=0; i<9; i++){
            rowFreq = new int[10];
            colFreq = new int[10];
            for(int j=0; j<9; j++){
                int row_val = board[i][j]-'0';
                int col_val = board[j][i]-'0';
                if((row_val)>0){
                    if(++rowFreq[row_val]>1)
                        return false;
                }
                if((col_val)>0){
                    if(++colFreq[col_val]>1)
                        return false;
                }
            }                         
        }  

        for(int i=0; i<=6; i+=3){
            for(int j=0; j<=6; j+=3){
                if(!isValidSegment(i,j, board))
                    return false;
            }
        }
        return true;
    }    

    public boolean isValidSegment(int row, int col, char[][] board){
        int[] freq = new int[10];
        for(int i=row; i<row+3; i++){
            for(int j=col; j<col+3; j++){
                int curr_val = board[i][j]-'0';
                if(curr_val>0)
                    if(++freq[curr_val]>1)
                        return false;
            }
        }
        return true;
    }
}