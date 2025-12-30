class Solution {
    public int countHillValley(int[] nums) {
        int i = 1, j = 1;
        int cnt = 0;
        while (i < nums.length - 1) {
            j = i;
            while (j < nums.length - 2 && nums[j + 1] == nums[j]) j++;    
            if ((nums[i-1] < nums[i] && nums[j] > nums[j+1]) || (nums[i-1] > nums[i] && nums[j] < nums[j+1])) {        
                cnt++;
            } 
            i = j + 1;
        }
        return cnt;
    }
}