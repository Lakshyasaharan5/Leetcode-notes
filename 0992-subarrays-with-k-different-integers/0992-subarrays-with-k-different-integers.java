class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);         
    }

    private int atMost(int[] nums, int k) {
        int l = 0, r = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int distinct = 0, subarrays = 0;
        while (r < nums.length) {
            if (freq.containsKey(nums[r])) {
                freq.put(nums[r], freq.get(nums[r]) + 1);
            } else {
                freq.put(nums[r], 1);
                distinct++;
            }
            while (distinct > k) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (freq.get(nums[l]) == 0) {
                    freq.remove(nums[l]);
                    distinct--;
                }
                l++;
            }
            subarrays += r - l + 1;
            r++;
        }

        return subarrays;
    }
}