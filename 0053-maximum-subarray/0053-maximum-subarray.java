class Solution {
    public int maxSubArray(int[] nums) {
        // -3 -2 -1 -4 4 -2 6
        // add
        // max sum
        // set to zero if neg
        int maxSum = nums[0];
        int currSum = 0;
        for (int n : nums) {
            currSum += n;
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) currSum = 0;
        }
        return maxSum;
    }
}