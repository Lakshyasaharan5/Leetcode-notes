class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    r--;
                    while (r > l && nums[r] == nums[r + 1]) r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }                
            }
        }
        return res;
        /**      i        
             -4 -1 -1 0 1 2
                    l
                          r

            if (found)
                l++
                r--
            else if l + r < target
                l++
            else 
                r--

        */
    }
}