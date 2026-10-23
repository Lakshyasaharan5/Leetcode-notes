class Solution {
    /**
            1 2 3         target = 3
            1,2  2,1
         1,1     
      1,0  

      Time: O(2^n)
      Space: O(target/min(candidates))

     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) return;
        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}