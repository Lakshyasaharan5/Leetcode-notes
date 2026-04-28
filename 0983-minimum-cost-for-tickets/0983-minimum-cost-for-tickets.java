class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int curr = Integer.MAX_VALUE;
            // 1 day pass
            curr = Math.min(curr, costs[0] + (i < n - 1 ? dp[i + 1] : 0));
            
            // 7 day pass
            int k = i;
            while (k < n && days[k] < days[i] + 7) k++;            
            curr = Math.min(curr, costs[1] + (k < n ? dp[k] : 0));
            
            // 30 day pass
            k = i;
            while (k < n && days[k] < days[i] + 30) k++;            
            curr = Math.min(curr, costs[2] + (k < n ? dp[k] : 0));

            dp[i] = curr;
        }
        return dp[0];
    }
}