class Solution {
    public int lengthOfLIS(int[] nums) {
        // 10,9,2,5,3,7,101,18
        //  2 2 4 3 3 2  1   1
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);        
        for (int i = nums.length - 2; i>=0; i--) {
            int curr = -1;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    curr = Math.max(curr, dp[j]);
                }
            }
            if (curr != -1) dp[i] = curr + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}