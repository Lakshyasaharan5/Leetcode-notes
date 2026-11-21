class Solution {
    /**
        000001 000011 001000 110000 001010
         l
                  r
        mask = 001001

        while (mask & nums[r] != 0) {
            remove nums[l]
            l++
        }
        update mask
        update longest

    
     */
    public int longestNiceSubarray(int[] nums) {
        int mask = 0;
        int longest = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            while ((mask & nums[r]) != 0) {
                mask = mask & ~nums[l];
                l++;
            }
            mask = mask | nums[r];
            longest = Math.max(longest, r - l + 1);
            r++;
        }
        return longest;
    }
}