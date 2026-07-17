class Solution {    
    public int deleteAndEarn(int[] nums) {                
        int[] dp = new int[10004];
        for (int n : nums) {
            dp[n] += n;
        }
        for (int i = 10001; i >= 1; i--) {
            dp[i] = Math.max(dp[i]+dp[i+2], dp[i+1]);
        }        
        return dp[1];
        /**            
            dp[i] = max(dp[i]+dp[i+2], dp[i+1])
            [0 0 0 0 0 0 12 6]
             2,2,3,3,3,4,6 ,6             
        */
        
    }   
}