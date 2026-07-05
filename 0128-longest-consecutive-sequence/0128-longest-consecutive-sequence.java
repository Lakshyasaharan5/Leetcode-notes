class Solution {
    public int longestConsecutive(int[] nums) {
        /**
        [100,4,200,1,3,2]
                   ^
          200-----
        */
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int longest = 0;
        for (int n : set) {
            if (set.contains(n - 1)) continue;
            int streak = 0;
            while (set.contains(n)) {
                streak++;
                n++;
            }
            longest = Math.max(longest, streak);

        }
        return longest;
    }
}