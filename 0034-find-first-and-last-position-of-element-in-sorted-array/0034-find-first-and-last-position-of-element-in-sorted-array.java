class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 0 1 2 3 4 5
        // 5,7,7,8,8,10
        //       l 
        //       m
        //       r
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        // find start position by bring r and keeping even sum
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (nums[r] != target) return new int[]{-1, -1};
        int[] res = new int[2];
        res[0] = r;
        // find end position by bringing l and keeping odd sum
        l = 0; r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2 + 1;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        res[1] = l;
        return res;
    }
}