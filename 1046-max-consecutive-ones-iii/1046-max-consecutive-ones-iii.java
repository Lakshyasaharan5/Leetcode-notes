class Solution {
    public int longestOnes(int[] nums, int k) {
        // 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1
        //     l
        //                   r
        // if (k == 0) {
        //     return maxConsecutiveOnes(nums);
        // }
        int l = 0, r = 0;
        int res = 0;
        while (r < nums.length) {
            if (nums[r] == 0) k--;            
            while (k < 0) {
                if (nums[l] == 0) k++;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    private int maxConsecutiveOnes(int[] nums) {
        // 0,0,1,1,0,0,1,1,1
        //             l
        //                  r
        int l = 0, r = 0, res = 0; 
        while (l < nums.length) {       
            while (l < nums.length && nums[l] == 0) {
                l++;
            }
            if (l == nums.length) return res;
            r = l;
            while (r < nums.length && nums[r] == 1) {
                r++;
            }
            res = Math.max(res, r - l);
            l = r + 1;
        }
        return res;
    }
}