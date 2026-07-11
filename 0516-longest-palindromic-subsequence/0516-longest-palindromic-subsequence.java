class Solution {
    public int longestPalindromeSubseq(String s) {
        /**
            a b c a
            if i > j return 0
            if i == j return 1
            if (equal) 
                return i+1,j-1 + 2
            else
                return max(i+1,j  ,  i,j-1)
            0 1 2 3 4 5 6
            a x x x x x b

            0 0 0 
            * X 0
            * * 0

            i n->0
              j -> 0->m

            0,4 -> 1,4 2,4
            2,6 -> 2,5 2,4
            1,5 -> 2,4
         */
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(s, 0, s.length() - 1, dp);
    }
    private int dfs(String a, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (a.charAt(i) == a.charAt(j)) {
            return dp[i][j] = 2 + dfs(a, i + 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(dfs(a, i + 1, j, dp), dfs(a, i, j - 1, dp));
    }
    /**
    if i > j return 0
            if i == j return 1
            if (equal) 
                return i+1,j-1 + 2
            else
                return max(i+1,j  ,  i,j-1)
     */
}