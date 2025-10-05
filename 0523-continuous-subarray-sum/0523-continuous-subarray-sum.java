class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) return false;
        if (nums.length == 2) return ((nums[0] + nums[1]) % k == 0);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0] % k, 0);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1]; 
            int mod = nums[i] % k;           
            if (i >= 1 && mod == 0) return true;
            if (map.containsKey(mod) && i - map.get(mod) > 1) return true;
            if (!map.containsKey(mod))
                map.put(nums[i] % k, i);
        }
        return false;
    }
}