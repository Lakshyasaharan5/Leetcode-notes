class Solution {    
    public boolean wordBreak(String s, List<String> wordDict) {
        // 0 1 2 3 4 5 6 7 8
        // c a t s a n d o g
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        Boolean[] dp = new Boolean[s.length() + 1];
        return dfs(s, wordSet, 0, dp);
    }

    private boolean dfs(String s, Set<String> wordSet, int start, Boolean[] dp) {
        if (start >= s.length()) return true;
        if (dp[start] != null) return dp[start];
        for(int i = start; i < s.length(); i++) {
            if (wordSet.contains(s.substring(start, i + 1))) {
                if (dfs(s, wordSet, i + 1, dp)) {
                    dp[start] = true;
                    return true;
                }
            }
        }
        dp[start] = false;
        return false;
    }
}