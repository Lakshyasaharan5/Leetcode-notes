class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0], cnt = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (curr == nums[j]) {
                cnt++;
            } else {
                curr = nums[j];
                cnt = 1;
            }
            if (cnt < 3) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}