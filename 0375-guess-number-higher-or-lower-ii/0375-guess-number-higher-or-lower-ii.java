class Solution {
    Integer[][] dp;
    public int getMoneyAmount(int n) {
        /*
                   1,2,3,4
        []1[2,3,4]    [1]2[3,4]  [1,2]3[4]   [1,2,3]4[]
        
        
        
                      [2,3,4]
            []2[3,4]  [2]3[4]  [2,3]4[]
        
            for i (l,r)
                min(curr + dfs(left) + dfs(right))   
        
            [1,2]3[4,5]
        
        
                           
                         
        */
        dp = new Integer[n + 1][n + 1];
        return dfs(1, n);
    }

    private int dfs(int l, int r) {
        if (l >= r)
            return 0;
        if (r - l == 1)
            return Math.min(l, r);
        if (dp[l][r] != null)
            return dp[l][r];
        int curr = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            curr = Math.min(curr, i + Math.max(dfs(l, i - 1), dfs(i + 1, r)));
        }
        return dp[l][r] = curr;
    }
}