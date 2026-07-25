class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        int lcs = dp[0][0];
        return m - lcs + n - lcs;
        /**
                 b d a
               d 0 0 0 0
               b 0 0 0 0
               a 0 0 0 0
                 0 0 0 0

               dp[i][j] = max(dp[i+1][j], dp[j+1][i])
         */
    }
}