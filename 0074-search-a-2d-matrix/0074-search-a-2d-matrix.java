class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // find the row
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = (l + r) / 2 + 1;
            if (matrix[mid][0] > target) r = mid - 1;
            else l = mid;
        }
        int row = l;
        // find the element in that row
        l = 0; r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}