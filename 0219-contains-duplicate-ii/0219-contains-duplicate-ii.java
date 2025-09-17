class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();
        
        // expand the window
        int l = 0, r = 0;
        while (r < nums.length && r - l <= k) {
            if (seen.contains(nums[r])) return true;
            seen.add(nums[r]);
            r++;
        }

        // slide the window
        while (r < nums.length) {
            seen.remove(nums[l++]);
            if (seen.contains(nums[r])) return true;
            seen.add(nums[r]);
            r++;
        }

        return false;   
    }
}