class Solution {
    public void nextPermutation(int[] nums) {
        int p = nums.length - 1;
        while (p > 0 && nums[p - 1] >= nums[p]) p--;

        int l = p, r = nums.length - 1;
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++; r--;
        }
        if (p == 0) return;
        int replace = p - 1;
        while (nums[replace] >= nums[p]) p++;

        int t = nums[replace];
        nums[replace] = nums[p];
        nums[p] = t;

    }
}