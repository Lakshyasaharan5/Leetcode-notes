class Solution {
    Integer[] dp;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new Integer[books.length];
        return dfs(books, shelfWidth, 0);
    }

    private int dfs(int[][] books, int shelfWidth, int start) {
        if (start >= books.length) return 0;     
        if (dp[start] != null) return dp[start];   
        int currentThickness = 0;
        int maxHeight = 0;
        int currBest = Integer.MAX_VALUE;
        for (int i = start; i < books.length; i++) {
            currentThickness += books[i][0];
            if (currentThickness > shelfWidth) break;
            maxHeight = Math.max(maxHeight, books[i][1]);
            currBest = Math.min(currBest, maxHeight + dfs(books, shelfWidth, i + 1));
        }
        return dp[start] = currBest;
    }
}