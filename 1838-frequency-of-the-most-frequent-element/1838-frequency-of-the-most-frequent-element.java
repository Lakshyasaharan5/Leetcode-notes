class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 0;
        long currSum = 0;
        int res = 0;
        while (r < n) {
            currSum += nums[r];
            if ((long)nums[r] * (r - l + 1) - currSum > k) {
                currSum -= nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);   
            r++;                         
        }
        return res;
    }
}