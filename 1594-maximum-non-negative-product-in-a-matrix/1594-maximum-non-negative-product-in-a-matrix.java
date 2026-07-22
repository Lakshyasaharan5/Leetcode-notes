class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] lowest = new long[m][n];
        long[][] highest = new long[m][n];

        lowest[m - 1][n - 1] = grid[m - 1][n - 1];
        highest[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (row == m - 1 && col == n - 1) {
                    continue;
                }

                long minProduct = Long.MAX_VALUE;
                long maxProduct = Long.MIN_VALUE;
                long value = grid[row][col];

                if (row + 1 < m) {
                    long product1 = value * lowest[row + 1][col];
                    long product2 = value * highest[row + 1][col];

                    minProduct = Math.min(minProduct, Math.min(product1, product2));
                    maxProduct = Math.max(maxProduct, Math.max(product1, product2));
                }

                if (col + 1 < n) {
                    long product1 = value * lowest[row][col + 1];
                    long product2 = value * highest[row][col + 1];

                    minProduct = Math.min(minProduct, Math.min(product1, product2));
                    maxProduct = Math.max(maxProduct, Math.max(product1, product2));
                }

                lowest[row][col] = minProduct;
                highest[row][col] = maxProduct;
            }
        }

        long result = highest[0][0];

        if (result < 0) {
            return -1;
        }

        return (int) (result % 1_000_000_007);
    }
}