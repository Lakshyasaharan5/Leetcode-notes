class Solution {
    /**
        n = 3, 
        rowShift = [1,2,0], colShift = [2,2,1]

        grid = [[1,2,3],
                [4,5,6],
                [7,8,9]], 

                [3 2 3] 
                       j
                   k               
                 
                 q = [1,2]
                 shift = 2
    
     */
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {        
        Queue<Integer> queue = new LinkedList<>();
        // row shifts
        for (int i = 0; i < rowShift.length; i++) {
            int rh = rowShift[i] % n;
            int j = 0;
            while (j < rh) {
                queue.offer(grid[i][j++]);
            }
            int k = 0;
            while (j < n) {
                grid[i][k++] = grid[i][j++];
            }
            while (k < n) {
                grid[i][k++] = queue.poll();
            }
        }

        // col shifts
        for (int c = 0; c < colShift.length; c++) {
            int ch = colShift[c] % n;
            int j = 0;
            while (j < ch) {
                queue.offer(grid[j++][c]);
            }
            int k = 0;
            while (j < n) {
                grid[k++][c] = grid[j++][c];
            }
            while (k < n) {
                grid[k++][c] = queue.poll();
            }
        }

        return grid;
    }
}