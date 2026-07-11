class Solution {
    public int numDistinct(String s, String t) {
        /**
                s = bxxxa
                       i
                t = axxxb
                      j

                if equal
                    return i+1,j+1 + i+1,j
                else
                    return i+1,j
                    00
              1/          1\
              11            10
                        1/        \0
                        21        20

                return left + right

         */
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(s, t, 0, 0, dp);
    }

    private int dfs(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = dfs(s, t, i + 1, j + 1, dp) + dfs(s, t, i + 1, j, dp);
        } 
        return dp[i][j] = dfs(s, t, i + 1, j, dp);
    }
}