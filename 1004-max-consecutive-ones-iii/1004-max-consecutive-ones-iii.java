class Solution {
    /**
        nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
                        l
                                    r
                zeros = 2
                longest = 5
     */
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int l = 0, r = 0;
        int longest = 0;

        while (r < nums.length) {
            if (nums[r] == 0) zeros++;
            while (zeros > k) {
                if (nums[l] == 0) zeros--;
                l++;
            }
            longest = Math.max(longest, r - l + 1);
            r++;
        }
        return longest;
    }
}