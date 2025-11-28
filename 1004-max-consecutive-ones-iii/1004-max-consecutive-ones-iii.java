class Solution {
    public int longestOnes(int[] nums, int k) {
        // 1,1,1,0,0,0,1,1,1,1,0
        //       l
        //           r
        int l = 0, r = 0;
        int res = 0;
        while (r < nums.length) {
            if (nums[r] == 0) k--;
            while (k < 0) {
                if (nums[l++] == 0) k++;                
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}