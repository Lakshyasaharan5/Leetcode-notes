class Solution {
    Integer[][] dp;
    public int stoneGameVII(int[] stones) {                
        int N = stones.length;
        dp = new Integer[N][N];
        return dfs(stones, 0, N - 1);
    }

    private int dfs(int[] stones, int i, int j) {
        if (i == j) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int left = getSum(stones, i + 1, j) - dfs(stones, i + 1, j);        
        int right = getSum(stones, i, j - 1) - dfs(stones, i, j - 1);
        return dp[i][j] = Math.max(left, right);
    }

    private int getSum(int[] stones, int i, int j) {
        int total = 0;
        for (int k = i; k <= j; k++) {
            total += stones[k];
        }
        return total;
    }
}