class Solution {
    public int lengthOfLIS(int[] nums) {
        /**
               4 6 5
            4     6        5
          6  5    5          
        5
            [2 1 1] 
             4 6 5

            dp[i] = max (for i (i + 1, n))
            curr = min
            for i (start+1->n)
                if (i > start)
                    curr = max(curr, dfs(i))

            return curr == min ? 0 : curr + 1
        
         */
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i])
                    curr = Math.max(curr, dp[j]);
            }
            dp[i] = (curr == Integer.MIN_VALUE ? 1 : curr + 1);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}