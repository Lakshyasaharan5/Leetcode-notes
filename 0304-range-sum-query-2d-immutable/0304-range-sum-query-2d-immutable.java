class NumMatrix {
    private int[][] prefixMatrix;
    private int m;
    private int n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;        
        prefixMatrix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pr = i + 1, pc = j + 1;
                prefixMatrix[pr][pc] = prefixMatrix[pr - 1][pc] + matrix[i][j] + prefixMatrix[pr][pc - 1] - prefixMatrix[pr - 1][pc - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return prefixMatrix[row2][col2] - prefixMatrix[row1 - 1][col2] - prefixMatrix[row2][col1 - 1] + prefixMatrix[row1 - 1][col1 - 1];        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */