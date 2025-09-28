class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, res);
        return res;
    }

    private void helper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // pick
        subset.add(nums[i]);
        helper(nums, i + 1, subset, res);
        
        // not pick
        subset.remove(subset.size() - 1);
        helper(nums, i + 1, subset, res);
    }
}