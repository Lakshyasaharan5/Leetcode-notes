class Solution {
    /**
            nums = [3,0,1,5,4]
                    t f t t t
                        i
                    3
                0    1    5
                    5     4
                    4
     */
    public boolean canJump(int[] nums) {
        int N = nums.length;
        boolean[] dp = new boolean[N];
        dp[N - 1] = true;
        for (int i = N - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j <= Math.min(N - 1, i + nums[i]); j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    
}