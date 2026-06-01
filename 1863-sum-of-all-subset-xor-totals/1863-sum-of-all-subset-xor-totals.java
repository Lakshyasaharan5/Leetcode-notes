class Solution {
    public int ans = 0;
    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int i, int xor) {
        if (i == nums.length) {
            ans += xor;
            return;
        }
        dfs(nums, i + 1, xor ^ nums[i]);
        dfs(nums, i + 1, xor);
    }
}