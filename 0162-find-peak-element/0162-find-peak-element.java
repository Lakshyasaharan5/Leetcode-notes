class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (m > 0 && nums[m - 1] > nums[m]) {
                r = m - 1;
            } else if (m < nums.length - 1 && nums[m + 1] > nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        } 
        return l;
    }
}