class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
                a c s d k f 
                d a r d a d

                i,j
            i+1,j   i,j+1    (i+1,j+1)+1               
        
        */
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(text1, text2, 0, 0, dp);
    }

    private int dfs(String a, String b, int i, int j, int[][] dp) {
        if (i == a.length() || j == b.length())
            return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        if (a.charAt(i) == b.charAt(j)) {
            return 1 + dfs(a, b, i + 1, j + 1, dp);
        }

        return dp[i][j] = Math.max(dfs(a, b, i + 1, j, dp), 
                                    dfs(a, b, i, j + 1, dp));
    }
}