class Solution {
    public int numSquares(int n) {        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int k = 1;
            int curr = Integer.MAX_VALUE;
            while (k * k <= i) {
                curr = Math.min(curr, dp[i - k * k]);
                k++;
            }
            dp[i] = curr + 1;
        }
        return dp[n];
    }
}