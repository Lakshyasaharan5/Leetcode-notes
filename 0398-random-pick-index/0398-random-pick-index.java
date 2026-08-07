class Solution {
    /**
        1 3 2 3
        0 1 2 3
              ^
          cnt = 2
          prob = 1/2
          pick = 2
     */
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int cnt = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            cnt++;
            if (random.nextInt(cnt) == 0) {
                index = i;
            }
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */