class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(k, 1);
        int found = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (seen.containsKey(prefix)) {
                found += seen.get(prefix);                
            }
            seen.put(prefix + k, seen.getOrDefault(prefix + k, 0) + 1);
        }
        return found;
        /**
            cnt = 1
            [1,1,1]     k=1
                 ^
            {
                1 : 2
            }
           0[1,1,1] prefix
            a b c
            c - a = k
            c = k + a
         */
    }
}