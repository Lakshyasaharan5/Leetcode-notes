class Solution {
    public int minFallingPathSum(int[][] matrix) {
        /**
            [14 , 13,  15],
            [13, 12, 12],
            [7,  8,  9]        
        */
        int n = matrix.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int left = (j - 1 < 0 ? Integer.MAX_VALUE : matrix[i + 1][j - 1]);
                int right = (j + 1 == n ? Integer.MAX_VALUE : matrix[i + 1][j + 1]);
                int bottom = matrix[i + 1][j];
                matrix[i][j] += Math.min(bottom, Math.min(left, right));
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, matrix[0][j]);
        }
        return res;
    }
}