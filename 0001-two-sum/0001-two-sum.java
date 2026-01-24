class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2,7,11,15    target = 9
        // ^
        // 7:0 
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (seen.containsKey(find)) {
                return new int[]{seen.get(find), i};
            }
            seen.put(nums[i], i);
        }

        return new int[2];
    }
}