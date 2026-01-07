class Solution {
    public long countGood(int[] nums, int k) {
        // 3,1,4,3,2,2,4
        //       l
        //             r
        // 3:1, 2:2 1:0 4:1 count = 1 res = 4
        int l = 0, r = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        long count = 0, res = 0;
        while (r < nums.length) {
            if (!freq.containsKey(nums[r])) freq.put(nums[r], 0);
            count += freq.get(nums[r]);
            freq.put(nums[r], freq.get(nums[r]) + 1);
            while (count >= k) {
                res += nums.length - r;
                freq.put(nums[l], freq.get(nums[l]) - 1);
                count -= freq.get(nums[l]);
                l++;
            }
            r++;
        }
        return res;
    }
}