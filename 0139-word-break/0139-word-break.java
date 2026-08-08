class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
                    acb
                    a,          ac,         acb
                   c,cb         b
                   b

               [a,ac,cb]     
        
         */
        dp = new Boolean[s.length()];
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wd, int start) {
        if (start >= s.length()) return true;
        if (dp[start] != null) return dp[start];
        for (int i=start; i < s.length(); i++) {
            String curr = s.substring(start,i + 1);
            if (match(curr, wd)) {
                if (dfs(s, wd, i + 1))
                    return dp[start] = true;
            }
        }
        return dp[start] = false;
    }

    private boolean match(String curr, List<String> wd) {
        for (String w : wd)
            if (curr.equals(w))
                return true;
        return false;
    }
}