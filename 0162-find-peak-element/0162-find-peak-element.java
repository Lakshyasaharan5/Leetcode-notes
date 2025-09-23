class Solution {
    public int findPeakElement(int[] nums) {
        // 0 1 2 3 4 5 6
        // 1,2,1,3,5,6,4
        //         m  
        //           l
        //           r
        int l = 0, r = nums.length;
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