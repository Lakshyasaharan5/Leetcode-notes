class Solution {
    public void nextPermutation(int[] nums) {       
        if (nums.length == 1) return;
        int e = nums.length - 2;
        while (e >= 0 && nums[e] >= nums[e+1]) e--;
        if (e < 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int replace = e;
        e = nums.length - 1;
        while (e > replace && nums[e] <= nums[replace]) e--;
        swap(nums, e, replace);
        reverse(nums, replace + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}