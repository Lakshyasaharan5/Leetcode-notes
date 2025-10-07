class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    res++;
                    helper(i, j, grid, visited);
                }
            }
        }
        return res;
    }

    public void helper(int i, int j, char[][] grid, boolean[][] visited){
        if(i==m || j==n || i<0 || j<0) return;

        if(grid[i][j]=='1' && !visited[i][j]){
            visited[i][j]=true;        
            helper(i+1, j, grid, visited);
            helper(i, j+1, grid, visited);
            helper(i, j-1, grid, visited);
            helper(i-1, j, grid, visited);
        }
    }
}