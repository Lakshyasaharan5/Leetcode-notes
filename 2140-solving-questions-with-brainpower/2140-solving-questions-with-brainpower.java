class Solution {
    Long[] dp;
    public long mostPoints(int[][] questions) {
        dp = new Long[questions.length];
        return dfs(questions, 0);
    }

    private long dfs(int[][] questions, int i) {
        if (i >= questions.length) return 0;
        if (dp[i] != null) return dp[i];
        long pick = questions[i][0] + dfs(questions, i + questions[i][1] + 1);
        long skip = dfs(questions, i + 1);
        return dp[i] = Math.max(pick, skip);
    }
}