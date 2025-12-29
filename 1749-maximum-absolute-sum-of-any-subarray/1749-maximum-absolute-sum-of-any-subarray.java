class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // [2,-5,1,-4,3,-2]
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MIN_VALUE;
        int currMaxSum = 0, currMinSum = 0;
        for (int n : nums) {
            currMaxSum += n;
            maxSum = Math.max(maxSum, currMaxSum);
            if (currMaxSum < 0) currMaxSum = 0;
            
            n *= -1;

            currMinSum += n;
            minSum = Math.max(minSum, currMinSum);
            if (currMinSum < 0) currMinSum = 0;
        }
        return Math.max(maxSum, minSum);
    }
} 