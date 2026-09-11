class Solution {
    /**
        days = [1,4,6,7,8,20], costs = [2,7,15]

        [1] 2 3 [4] 5 [6] [7] [8] 9 10.... [20]......365

        days[i]:
            buy 1day, 7day, 30day pass
        
        return min(1, 7, 30)


     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return dfs(days, 0, costs, dp);
    }

    private int dfs(int[] days, int i, int[] costs, int[] dp) {
        if (i >= days.length) 
            return 0;

        if (dp[i] != -1) return dp[i];
        
        //1 day pass
        int _1DayPass = costs[0] + dfs(days, i + 1, costs, dp);

        //7 day pass
        int d = i;
        while (d < days.length && days[d] < days[i] + 7) {
            d++;
        }
        int _7DayPass = costs[1] + dfs(days, d, costs, dp);

        //30 day pass
        d = i;
        while (d < days.length && days[d] < days[i] + 30) {
            d++;
        }
        int _30DayPass = costs[2] + dfs(days, d, costs, dp);

        return dp[i] = Math.min(_1DayPass, Math.min(_7DayPass, _30DayPass));
    }
}