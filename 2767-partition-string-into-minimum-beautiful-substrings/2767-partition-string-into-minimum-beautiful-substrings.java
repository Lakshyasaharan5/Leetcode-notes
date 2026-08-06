class Solution {
    Integer[] dp;
    public int minimumBeautifulSubstrings(String s) {
        /**
                1 = 1
                5 = 101
                25= 11001

                2|_25, 1
                2|_12, 0
                2|_6,  0
                2|_3,  1
                 |_1,  1

                1011

                1, 10, 101, 1011
                
                10
              1    10
              0


         */
        dp = new Integer[s.length()];
        int res = dfs(s, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(String s, int start) {
        if (start >= s.length()) return 0;
        if (dp[start] != null) return dp[start];
        int min = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            String curr = s.substring(start, i + 1); 
            if (curr.charAt(0) == '0' || !isPower5(curr)) continue;
            min = Math.min(min, dfs(s, i + 1));
        }
        return dp[start] = min == Integer.MAX_VALUE ? min : min + 1;
    }

    private boolean isPower5(String binary) {
        // 101
        int mul = 1;
        int number = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            int b = (binary.charAt(i) == '0' ? 0 : 1);
            number += b * mul;
            mul *= 2;
        }
        while (number != 1) {
            if (number % 5 != 0) return false;
            number /= 5;
        }
        return true;
    }
}