class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solver(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    void solver(int[] candidates, int target, int idx, int currSum, List<Integer> temp, List<List<Integer>> res){
        if(idx >= candidates.length) return;
        if(currSum > target){
            temp.remove(temp.size() - 1);
            return;
        }

        if(currSum == target){
            res.add(new ArrayList<>(temp));
        }

        for(int i = idx; i < candidates.length; i++){
            temp.add(candidates[i]);
            solver(candidates, target, i, currSum + candidates[i], temp, res);
        }
        if(temp.size() > 0)
        temp.remove(temp.size() - 1);
    }
}