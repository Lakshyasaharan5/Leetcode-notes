class Solution {
    public int[] twoSum(int[] nums, int target) {        
        int n = nums.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int check = target - nums[i];
            if (indexMap.containsKey(check)) {
                return new int[]{indexMap.get(check), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
        /**
             0  1  2  3
            [2,15,11,7]     target = 9
                     ^
            2 : 0
            15: 1
            11: 2
            return [curr idx, map.get(target - curr)]
        */
    }
}