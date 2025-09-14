class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();        
        for(int n : nums){
            seen.add(n);
        }
        int res = 0;
        for(int n : seen){
            if (seen.contains(n - 1)) continue;
            int streak = n;
            while (seen.contains(streak + 1)){
                streak++;
            }
            res = Math.max(res, streak - n + 1);
        }
        return res;
    }
}