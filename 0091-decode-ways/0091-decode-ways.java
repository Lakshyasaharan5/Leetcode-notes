class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, 0, dp);
    }

    private int dfs(String s, int i, int[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != -1) return dp[i];
        int left = dfs(s, i + 1, dp);        
        int right = 0;
        if (i < s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26) 
            right = dfs(s, i + 2, dp);
        return dp[i] = left + right;
    }
}