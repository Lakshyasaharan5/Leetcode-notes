class Solution {
    Boolean[] dp;
    public boolean divisorGame(int n) {
        dp = new Boolean[1001];
        return canWin(n);
    }

    private boolean canWin(int n) {
        if (dp[n] != null) return dp[n];        
        for (int i = 1; i < n; i++) {
            if (n % i == 0 && !canWin(n - i)) {
                return dp[n] = true;
            }
        }
        return dp[n] = false;
    }
}