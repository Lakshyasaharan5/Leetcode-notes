class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n < 3) return Math.max(nums[0], nums[1]);
        int a = nums[n - 2], b = nums[n - 1], c = 0;
        for (int i = n - 3; i >= 0; i--) {
            int d = Math.max(b, c) + nums[i];
            c = b;
            b = a;
            a = d;
        }
        return Math.max(a, b);
    }
}