class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                int a = nums[i], b = nums[nums[i] - 1];
                nums[nums[i] - 1] = a;
                nums[i] = b;
            }
        }
        int j = 0;
        while (j < n) {
            if (nums[j] - 1 != j) return j + 1;
            j++;
        }
        return j+1;
        /**
              0 1 2 3 4
             [1,4,3,-1]
                       ^                
                nums[i] < len
                nums[i] >= 0
                num[[nums[i]] - 1] != num[i]            
        */         
    }
}