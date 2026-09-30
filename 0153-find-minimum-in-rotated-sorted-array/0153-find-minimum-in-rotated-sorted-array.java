class Solution {
    /**
        0 1 2 3 4
        3,4,5,1,2
            m
        l
                r

        ssssssss
            m

        llllll*ssss
              m
        r<m
        r>m

        21
        m
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (r - l)/2 + l;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}