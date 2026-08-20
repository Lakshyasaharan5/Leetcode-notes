class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        /**
                2 2 
               2   ~
            2   ~  2   ~

            1    2    2
          12 12  22
        122   
         
        1    2     3
       12 13 23     
     123     
                                 
         */
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) continue;
            curr.add(nums[i]);        
            backtrack(nums, i + 1, curr, res);            
            curr.remove(curr.size() - 1);
        }
    }
}