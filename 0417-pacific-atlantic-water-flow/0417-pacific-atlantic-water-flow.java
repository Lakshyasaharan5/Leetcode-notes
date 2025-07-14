class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;

        // pacific side
        boolean[][] pacificVisited = new boolean[ROWS][COLS];
        for (int col = 0; col < COLS; col++)
            dfs(heights, 0, col, pacificVisited, heights[0][col]);
        for (int row = 0; row < ROWS; row++)
            dfs(heights, row, 0, pacificVisited, heights[row][0]);

        // atlantic side
        boolean[][] atlanticVisited = new boolean[ROWS][COLS];
        for (int col = 0; col < COLS; col++)
            dfs(heights, ROWS - 1, col, atlanticVisited, heights[ROWS - 1][col]);
        for (int row = 0; row < ROWS; row++)
            dfs(heights, row, COLS - 1, atlanticVisited, heights[row][COLS - 1]);

        // check common nodes
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacificVisited[r][c] && atlanticVisited[r][c]){
                    List<Integer> commonPair = new ArrayList<>();
                    commonPair.add(r);
                    commonPair.add(c);
                    res.add(commonPair);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        if (row < 0 || col < 0 ||
                row >= heights.length || col >= heights[0].length ||
                visited[row][col] ||
                heights[row][col] < prevHeight) {
            return;
        }

        visited[row][col] = true;

        for (int[] dir : DIRECTIONS) {
            dfs(heights, row + dir[0], col + dir[1], visited, heights[row][col]);
        }
    }
}