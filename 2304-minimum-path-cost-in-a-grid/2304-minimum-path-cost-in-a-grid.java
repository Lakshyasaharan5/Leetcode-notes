class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        /**
        
            grid = [[5,1,2],
                    [4,0,3]],


            grid = [[8,1,2],
                    [4,0,3]], 

                grid[i][j] += min(grid[i+1][j]+cost[i][j])
                2 + min(4+5,0+3,3+2)
            moveCost = 
            [[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]
                   0         1       2          3        4       5
        
         */
        int m = grid.length, n = grid[0].length;
        int res = Integer.MAX_VALUE;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {                
                int curr = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++)
                    curr = Math.min(curr, grid[i+1][k]+moveCost[grid[i][j]][k]);
                grid[i][j] += curr;
                
            }
        }
        int answer = Integer.MAX_VALUE;

        for (int cost : grid[0]) {
            answer = Math.min(answer, cost);
        }

        return answer;
    }
}