class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        dp = new Integer[s1.length()][s2.length()];
        return dfs(s1, s2, 0, 0);
    }

    private int dfs(String s1, String s2, int i, int j) {
        if (i == s1.length() && j == s2.length()) {
            return 0;
        }
        if (i == s1.length()) {
            int curr = 0;
            for (char c : s2.substring(j).toCharArray()) {
                curr += (int)c;
            }
            return curr;
        }
        if (j == s2.length()) {
            int curr = 0;
            for (char c : s1.substring(i).toCharArray()) {
                curr += (int)c;
            }
            return curr;
        }
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = dfs(s1, s2, i + 1, j + 1);
        }
        int left = dfs(s1, s2, i, j + 1) + (int)s2.charAt(j);
        int right = dfs(s1, s2, i + 1, j) + (int)s1.charAt(i);
        return dp[i][j] = Math.min(left, right);
    }
}