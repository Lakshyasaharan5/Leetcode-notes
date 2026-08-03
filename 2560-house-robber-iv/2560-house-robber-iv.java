class Solution {
    public int minCapability(int[] nums, int k) {
        /**
                nums = [2,3,5,9],           k = 2
                        i
                2 3 4 5 6 7 8 9


                3,3,20  k=2
                3,20,3  k=2
                20,3,3  k=2
        */
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int n : nums) {
            l = Math.min(l, n);
            r = Math.max(r, n);
        }
        while (l < r) {
            int m = (l + r) / 2;
            if (verify(nums, k, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean verify(int[] nums, int k, int capability) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= capability) {
                k--;
                i++;
            }
            if (k == 0) return true;
        }
        return false;
    }
}