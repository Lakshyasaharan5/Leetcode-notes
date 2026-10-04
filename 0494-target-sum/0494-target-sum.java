class Solution {
    /**
        nums = [1,1,1,1,1], target = 3
                         i
                1    -1
             2     0
            3 1   1 -1       
           4 2
         5 3      

         dfs(i, sum):
            if (i == len): 
                target == 0

            left = dfs(i+1, sum + nums[i])
            right = dfs(i+1, sum - nums[i])
            return left + right

     */
    Map<String, Integer> dp;
    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap<>();
        return dfs(nums, target, 0);
    }

    private int dfs(int[] nums, int target, int i) {
        if (i == nums.length) {
            if (target == 0) return 1;
            return 0;
        }
        String key = target + "-" + i;
        if (dp.containsKey(key)) return dp.get(key);
        int left = dfs(nums, target + nums[i], i + 1);
        int right = dfs(nums, target - nums[i], i + 1);
        dp.put(key, left + right);
        return dp.get(key);
    }
}