class Solution {
    public int maxSubArray(int[] nums) {
        // [-2,1,-3,4,-1,2,1,-5,4]
        //   i
        //   -5 -2 
        int res = nums[0];
        int curr = 0;
        for (int n : nums) {
            curr += n;
            if (curr < 0) {
                res = Math.max(res, n);    
                curr = 0;
            } else
                res = Math.max(res, curr);
        }
        return res;
    }
}