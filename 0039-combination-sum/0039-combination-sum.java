class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    void solve(int[] candidates, int target, int idx, int currSum, List<Integer> tmp, List<List<Integer>> res){
        if(currSum == target){
            res.add(new ArrayList<>(tmp));            
            return;
        }
        if(currSum > target || idx == candidates.length){
            return;
        }
        tmp.add(candidates[idx]);
        System.out.println(tmp.toString());
        solve(candidates, target, idx, currSum+candidates[idx], tmp, res);        
        tmp.remove(tmp.size()-1);
        solve(candidates, target, idx+1, currSum, tmp, res);
    }
}