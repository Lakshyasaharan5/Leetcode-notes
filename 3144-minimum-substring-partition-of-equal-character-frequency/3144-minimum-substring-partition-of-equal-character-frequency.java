class Solution {
    Integer[] dp;
    public int minimumSubstringsInPartition(String s) {
        /**
                abb
                  
            a,2       ab,2      abb,~
           b bb        b
         b
         */
        dp = new Integer[s.length()];
        int res = dfs(s, 0);
        return res;
    }

    private int dfs(String s, int start) {
        if (start >= s.length()) return 0;
        if (dp[start] != null) return dp[start];
        int[] freq = new int[26];
        int min = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            String curr = s.substring(start, i + 1);
            freq[s.charAt(i) - 'a']++;
            if (!isBalanced(freq)) continue;
            min = Math.min(min, dfs(s, i + 1));
        }
        if (min == Integer.MAX_VALUE) return min;
        return dp[start] = min + 1;
    }

    private boolean isBalanced(int[] freq) {
        int check = -1;
        for (int f : freq) {
            if (f > 0) {
                if (check == -1) {
                    check = f;
                }
                if (check != f) return false;
            }

        }
        return true;
    }
}