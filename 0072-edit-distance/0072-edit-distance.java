class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if(n1 == 0 && n2 == 0) return 0;
        if (n1 == 0 || n2 == 0) {
            return n1 == 0 ? n2 : n1;
        }
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 0; i <= n1; i++) dp[i][n2] = n1 - i;
        for(int j = 0; j <= n2; j++) dp[n1][j] = n2 - j;
        if(word1.charAt(n1 - 1) != word2.charAt(n2 - 1)) dp[n1 - 1][n2 - 1] = 1;
        
        for(int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (i == n1 - 1 && j == n2 - 1) continue;
                if(word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i+1][j+1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i+1][j+1]) + 1;
                 
            }
        }

        return dp[0][0];
    }
}