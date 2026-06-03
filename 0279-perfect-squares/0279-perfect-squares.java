class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int curr = i;
            for (int j = 1; j * j <= i; j++) {
                curr = Math.min(curr, dp[i - j * j]);
            }
            dp[i] = curr + 1;
        }
        return dp[n];
    }
}