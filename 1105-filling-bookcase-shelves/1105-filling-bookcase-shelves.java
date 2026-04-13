class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        // [0, 1, 2, 3]
        for (int i = n - 1; i >= 0; i--) {
            int currMaxHeight = 0;
            int currThickness = 0;
            int currBest = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                currThickness += books[j][0];
                if (currThickness > shelfWidth) break;
                currMaxHeight = Math.max(currMaxHeight, books[j][1]);
                currBest = Math.min(currBest, currMaxHeight + dp[j + 1]);                
            }
            dp[i] = currBest;
        }

        return dp[0];
    }
}