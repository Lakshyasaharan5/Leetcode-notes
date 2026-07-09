class Solution {
    public int minDistance(String word1, String word2) {
        /**
            a b 
            c 
            min(del, rep, ins)
            min(i+1,j    i+1,j+1,     i,j+1)
                       (ab, c)
            d/             r|               i\
          b,c              cb,c             cab,c
    '',c  c,c 

            a b c d
                    i
            s d a c 
                j

        */
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        return dfs(word1, word2, 0, 0, dp);
    }

    private int dfs(String a, String b, int i, int j, int[][] dp) {
        if (i == a.length() && j == b.length()) 
            return 0;
        if (i == a.length()) {
            return b.length() - j;
        }
        if (j == b.length()) {
            return a.length() - i;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (a.charAt(i) == b.charAt(j)) {
            return dfs(a, b, i + 1, j + 1, dp);
        }
        int del = dfs(a, b, i + 1, j, dp);
        int rep = dfs(a, b, i + 1, j + 1, dp);
        int ins = dfs(a, b, i, j + 1, dp);
        return dp[i][j] = Math.min(Math.min(del, rep), ins) + 1;
    }
}