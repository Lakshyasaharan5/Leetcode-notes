class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        /**
                    1 2 3
              1       2          3
             [2,3]   [1,3]      [2,1]
             2   3
            [3]  [2]

                    1,2
                  1,[2]    2,[1]
                2           1


                123
             1,23    2,13   3,21
           2,3 3,2
           3,    2,                                  
         */
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> res) {
        if (start >= nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        Set<Integer> alreadyStart = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (alreadyStart.contains(nums[i])) continue;
            alreadyStart.add(nums[i]);
            //swap
            swap(nums, start, i);
            //add to list
            curr.add(nums[start]);
            //dfs
            backtrack(nums, start + 1, curr, res);
            //remove from list
            curr.remove(curr.size() - 1);
            //unswap
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}