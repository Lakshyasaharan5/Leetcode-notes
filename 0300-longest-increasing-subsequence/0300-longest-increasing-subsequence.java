class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            int maxVal = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}