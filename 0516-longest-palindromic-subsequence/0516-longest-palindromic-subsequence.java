class Solution {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        dp = new Integer[s.length()][s.length()];
        return lcs(s, new StringBuilder(s).reverse().toString(), 0, 0);
    }

    private int lcs(String a, String b, int i, int j) {
        if (i >= a.length() || j >= b.length()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + lcs(a, b, i + 1, j + 1);
        }
        return dp[i][j] = Math.max(lcs(a, b, i + 1, j), lcs(a, b, i, j + 1));
    }
}