class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        // create dsu parent array of the grid
        int[] parents = new int[m * n];
        for (int i = 0; i < m*n; i++) {
            parents[i] = i;
        }
        int islands = 0;
        // we traverse the grid checking down and right, updating dsu
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') continue;
                islands++;
                // right
                if (j+1 < n && grid[i][j+1] == '1') {
                    islands = union(parents, i*n+j, i*n+j+1, islands);
                }
                // down
                if (i+1 < m && grid[i+1][j] == '1') {
                    islands = union(parents, i*n+j, (i+1)*n+j, islands);
                }
            }
        }

        return islands;
    }

    private int find(int[] parents, int index) {
        while (parents[index] != index) {
            index = parents[index];
        }
        return index;
    }

    private int union(int[] parents, int a, int b, int islands) {
        int rootA = find(parents, a);
        int rootB = find(parents, b);
        if (rootA != rootB) {
            islands--;
            parents[rootB] = rootA;
        }
        return islands;
    }
}