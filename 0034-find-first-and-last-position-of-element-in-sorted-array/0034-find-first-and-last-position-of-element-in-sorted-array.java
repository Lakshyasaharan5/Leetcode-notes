class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };

        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = (h - l) / 2 + l;
            if (nums[m] >= target)
                h = m;
            else
                l = m + 1;
        }

        if (nums[l] != target)
            return new int[] { -1, -1 };

        int[] res = {l, -1};
        l = 0; h = nums.length - 1;
        while (l < h) {
            int m = (h - l) / 2 + l + 1;
            if (nums[m] <= target)
                l = m;
            else
                h = m - 1;
        }

        res[1] = l;
        return res;
    }
}