class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l = 0, r = n - 1;
        while (l < r) {
            for (int i = 0; i < n; i++) {
                int tmp = matrix[l][i];
                matrix[l][i] = matrix[r][i];
                matrix[r][i] = tmp;
            }
            l++;
            r--;
        }

        int diagonal = 0;
        while (diagonal < n ) {
            for (int i = diagonal; i < n; i++) {
                int tmp = matrix[diagonal][i];
                matrix[diagonal][i] = matrix[i][diagonal];
                matrix[i][diagonal] = tmp;
            }
            diagonal++;
        }
    }
    
}