class Solution {
    /**
        catsand

        cat  cats 
              and

        cat, and, cats, 
     */
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String w : wordDict) {
            words.add(w);
        }
        dp = new Boolean[s.length()];
        return dfs(s, 0, words);
    }

    private boolean dfs(String s, int start, Set<String> words) {
        if (start >= s.length()) return true;
        if (dp[start] != null) return dp[start];
        for (int i = start; i < s.length(); i++) {
            if (words.contains(s.substring(start, i + 1))) {
                if (dfs(s, i + 1, words)) {
                    return dp[start] = true;
                }
            }
        }
        return dp[start] = false;
    }
}