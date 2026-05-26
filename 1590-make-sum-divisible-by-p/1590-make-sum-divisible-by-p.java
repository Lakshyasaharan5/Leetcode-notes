class Solution {
    public int minSubarray(int[] nums, int p) {        
        int n = nums.length;
        long total = 0;
        for (int num : nums) 
            total += num;
        if (total < p) return -1;
        if (total % p == 0)
            return 0;
        long currSum = 0;
        int k = (int)(total % p);
        Map<Integer, Integer> modIndex = new HashMap<>();
        modIndex.put(k, -1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];            
            int mod = (int)(currSum % p);            
            if (modIndex.containsKey(mod)) {
                if (i - modIndex.get(mod) == n) continue;
                min = Math.min(min, i - modIndex.get(mod));
            }
            modIndex.put(((int)(currSum % p) + k) % p , i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}