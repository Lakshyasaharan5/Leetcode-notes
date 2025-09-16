class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        //     l 
        //            r
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -1 * nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));                    
                }
                if (sum > target){
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--;                                        
                }
                else{
                    l++;                
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
               
            }
        }
        return res;
    }
}