class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()][s2.length()];
        return dfs(s1, 0, s2, 0, s3, 0, dp);
    }

    private boolean dfs(String s1, int i, String s2, int j, String s3, int k, Boolean[][] dp) {
        if (i >= s1.length() && j >= s2.length() && k >= s3.length()) return true;
        if (i >= s1.length()) return s2.substring(j).equals(s3.substring(k));
        if (j >= s2.length()) return s1.substring(i).equals(s3.substring(k));
        if (dp[i][j] != null) return dp[i][j];
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        char c3 = s3.charAt(k);
        boolean currResult = false;
        if (c1 == c3 && c2 == c3) {
            currResult = dfs(s1, i+1, s2, j, s3, k+1, dp) || dfs(s1, i, s2, j+1, s3, k+1, dp);
        } else if (c1 == c3) {
            currResult = dfs(s1, i+1, s2, j, s3, k+1, dp);
        } else if (c2 == c3) {
            currResult = dfs(s1, i, s2, j+1, s3, k+1, dp);
        }
        return dp[i][j] = currResult;
    }
}