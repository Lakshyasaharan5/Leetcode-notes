class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int i=0; i<dungeon.length; i++){
            for(int j=0; j<dungeon[0].length; j++){
                dp[i][j]=-1;
            }
        }
        return helper(dungeon, 0, 0, dp);
    }

    public int helper(int[][] dungeon, int i, int j, int[][] dp){

        if(i>=dungeon.length || j>=dungeon[0].length) return Integer.MAX_VALUE;

        if(i==dungeon.length-1 && j==dungeon[0].length-1){
            if(dungeon[i][j]>=0){
                return dp[i][j] = 1;
            }else{
                return dp[i][j] = -1*dungeon[i][j] + 1;
            }
        }
        
        if(dp[i][j]>-1)return dp[i][j];

        int a = helper(dungeon, i+1, j, dp);
        int b = helper(dungeon, i, j+1, dp);
        int curr = Math.min(a,b);
        
        if(dungeon[i][j]>=0 && dungeon[i][j]>=curr){
           return dp[i][j] = 1;
        }

        return dp[i][j] = curr-dungeon[i][j];
    }
}