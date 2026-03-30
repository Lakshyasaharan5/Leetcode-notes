class Solution {
    Integer[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][nums2.length];
        return maxUncrossedLines(nums1, nums2, 0, 0);
    }

    private int maxUncrossedLines(int[] nums1, int[] nums2, int i, int j) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }
        if (dp[i][j] != null) return dp[i][j];
        if (nums1[i] == nums2[j]) {
            return dp[i][j] = 1 + maxUncrossedLines(nums1, nums2, i + 1, j + 1);
        }

        return dp[i][j] = Math.max(maxUncrossedLines(nums1, nums2, i + 1, j), maxUncrossedLines(nums1, nums2, i, j + 1));
    }
}