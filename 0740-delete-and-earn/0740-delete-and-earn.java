class Solution {
    Integer[] dp;
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        /**
              0 1 2 3 4 5 6 7
             [2,2,3,3,3,4,6,6]
                              i  
            pick 2 and dfs([4,6,6])
            skip 2 and dfs([3....])
            max(pick, skip)
        */
        dp = new Integer[nums.length];
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int start) {
        if (start >= nums.length) return 0;
        if (dp[start] != null) return dp[start];
        //pick        
        int i = start;
        while (i < nums.length && nums[i] == nums[start]) {
            i++;
        }
        int nextGreater = i;
        int currTotal = nums[start] * (i - start);
        while (i < nums.length && nums[i] == nums[start] + 1) {
            i++;
        }
        int pick = dfs(nums, i) + currTotal;

        //skip
        int skip = dfs(nums, nextGreater);
        return dp[start] = Math.max(pick, skip);
    }
}