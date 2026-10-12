class Solution {
    /**
            1 4 2 4     
                     i
            1 2 4
                j
            if (i == j):
                dfs(i+1,j+1)
            else
                max(i+1,j and i,j+1)
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(nums1, nums2, 0, 0, dp);
    }

    private int dfs(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (nums1[i] == nums2[j]) {
            return dp[i][j] = dfs(nums1, nums2, i + 1, j + 1, dp) + 1;
        } 

        return dp[i][j] = Math.max(dfs(nums1, nums2, i + 1, j, dp), dfs(nums1, nums2, i, j + 1, dp));
        
    }
}