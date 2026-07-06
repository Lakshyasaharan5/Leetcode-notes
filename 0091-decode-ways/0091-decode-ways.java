class Solution {
    public int numDecodings(String s) {
        /**                      
            101
            012
             0  
           /    \     
          ~1       2  
        /   \    /  \
       2     3   3   4
      / \
            if i==len: return 1
            if i>len: return max
            if s[i] == 0 return max
         */
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, 0, dp);
    }

    private int dfs(String s, int i, int[] dp) {
        if (i == s.length()) return 1;
        if (i > s.length() || s.charAt(i) == '0') return 0;
        if (dp[i] != -1) return dp[i];
        int singleDigit = dfs(s, i + 1, dp);
        int doubleDigit = 0;
        if (i < s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26)
            doubleDigit = dfs(s, i + 2, dp);
        return dp[i] = singleDigit + doubleDigit;
    }
}