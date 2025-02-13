class Solution {
    public int findDuplicate(int[] nums) {
        int idx = nums[0];

        while(true){           
            if(nums[idx]<0) break; 
            nums[idx] *= -1;            
            idx = -1 * nums[idx];
        }

        return idx;
    }
}