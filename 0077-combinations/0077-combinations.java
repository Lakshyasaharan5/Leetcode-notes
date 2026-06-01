class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> curr, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            backtrack(n, k - 1, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}