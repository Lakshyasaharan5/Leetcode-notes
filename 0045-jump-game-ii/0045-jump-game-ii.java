class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int jumps = 0;
        int currReach = nums[0], maxReach = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + i > maxReach) maxReach = nums[i] + i;
            if (i == currReach || i == nums.length - 1) {
                currReach = maxReach;
                jumps++;
            }
        }
        return jumps;
    }
}