class Solution {
    Integer[][] dp;
    public int numTeams(int[] rating) {
        int n = rating.length;        
        int res = 0;
        dp = new Integer[n][3];
        for (int i = 0; i < n; i++) {
            res += dfs(rating, i, 2, true);          
        } 
        dp = new Integer[n][3];
        for (int i = 0; i < n; i++) {
            res += dfs(rating, i, 2, false);
        } 
        return res;
    }

    private int dfs(int[] rating, int start, int remaining, boolean ascending) {
        if (remaining == 0) return 1;
        if (dp[start][remaining] != null) return dp[start][remaining];
        int curr = 0;
        for (int i = start + 1; i < rating.length; i++) {
            if ((ascending && rating[i] > rating[start]) || (!ascending && rating[i] < rating[start])) {
                curr += dfs(rating, i, remaining - 1, ascending);
            }      
        }
        return dp[start][remaining] = curr;
    }
}