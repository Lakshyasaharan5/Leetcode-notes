class Solution {
    public long maxAlternatingSum(int[] nums) { 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] *= -1;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int mid = n/2;        
        int l = 0, r = mid;
        long res = 0;
        while (l < mid && r < n) {
            res += nums[r]*nums[r] - nums[l]*nums[l];
            l++;
            r++;
        }
        if (r < n) res += nums[r]*nums[r];
        return res;
    }
}