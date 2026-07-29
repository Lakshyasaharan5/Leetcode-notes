class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        /**        
                [5,3,4,5]
                 
                   5,3
            /                 \
           5,[3]             3,[5]
            |                  |
            3,[]              5,[]

            a+b > c+d

            a,b,c,d
            a-(b-(c-d))
            a-b+c-d

            return left > 0 or right > 0
                 
         */
        dp = new Integer[piles.length][piles.length];
        return dfs(piles, 0, piles.length - 1) >= 0;
    }

    private int dfs(int[] piles, int l, int r) {
        if (l == r) return piles[l];
        if (dp[l][r] != null) return dp[l][r];
        int left = piles[l] - dfs(piles, l + 1, r);
        int right = piles[r] - dfs(piles, l, r - 1);
        return dp[l][r] = Math.max(left, right);
    }
}