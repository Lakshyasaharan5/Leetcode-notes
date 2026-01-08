class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // 1,1,0,2,1,1,0,0,0,2,2,1,2,1,2,9
        //     l
        //       r
        if (nums.length < 3) return 0;
        int l = 0, r = 1;
        int diff = nums[r] - nums[l];
        int res = 0;
        while (r < nums.length - 1) {
            if (nums[r + 1] - nums[r] == diff) {
                r++;
            } else {
                int n = r - l + 1;
                if (n >= 3) {                    
                    res += ((n - 2) * (n - 1))/2;
                }
                l = r;
                r++;
                diff = nums[r] - nums[r - 1];
            }
        }
        int n = r - l + 1;
        if (n >= 3) {                    
            res += ((n - 2) * (n - 1))/2;
        }
        return res;
    }
}