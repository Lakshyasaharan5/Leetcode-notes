class Solution {
    public int threeSumClosest(int[] nums, int target) {
        /**        
            nums = [-1,2,1,-4]   target = 100
              
                v findnear 99
             [0,1,1,1]
                  l
                    r
                     diff2sum = 98
                     curr2sum = 2
             best = 2, 

         */
        Arrays.sort(nums);
        int best = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int findNear = target - nums[i];
            int l = i + 1, r = nums.length - 1;
            int curr2sum = 0, diff2sum = Integer.MAX_VALUE;            
            while (l < r) {
                curr2sum = nums[l] + nums[r];
                if (Math.abs(findNear - curr2sum) < Math.abs(diff2sum)) {
                    diff2sum = findNear - curr2sum;
                    if (Math.abs(target - curr2sum - nums[i]) < Math.abs(target - best))
                        best = curr2sum + nums[i];
                }
                if (findNear - curr2sum < 0) {
                    r--;
                } else {
                    l++;
                }
            }            
        }
        return best;
    }
}