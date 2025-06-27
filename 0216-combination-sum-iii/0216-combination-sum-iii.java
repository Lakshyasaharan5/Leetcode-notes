class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
     List<List<Integer>> res = new ArrayList<>();
     backtrack(k, n, 1, 0, new ArrayList<>(), res);
     return res;   
    }

    void backtrack(int k, int n, int idx, int currSum, List<Integer> tmp, List<List<Integer>> res){
        if(k==0 && currSum==n){
            res.add(new ArrayList<>(tmp));
            return;
        }

        if(idx > 9 || k < 0 || currSum > n){
            return;
        }

        for(int i=idx; i<=9; i++){
            tmp.add(i);
            backtrack(k-1, n, i+1, currSum+i, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}