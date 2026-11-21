class Solution {
    public int longestSubarray(int[] nums) {
        int k = 1;
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
        return longest - 1;
    }
}