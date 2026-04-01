class Solution {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        dp = new Integer[N][N];
        return lps(s, 0, N - 1);
    }

    private int lps(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            int length = (i == j ? 1 : 2);
            return dp[i][j] = length + lps(s, i + 1, j - 1);
        } 

        return dp[i][j] = Math.max(lps(s, i + 1, j), lps(s, i, j - 1));
    }
}