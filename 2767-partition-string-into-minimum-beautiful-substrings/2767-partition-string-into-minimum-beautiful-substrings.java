class Solution {

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

                1011~
                2~210


                1, 10, 101, 1011
                
                10
              1    10
              0


         */
        
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                String curr = s.substring(i, j + 1);
                if (curr.charAt(0) == '0') break;
                if (!isPower5(curr)) continue;
                min = Math.min(min, dp[j + 1]);
            }
            dp[i] = min == Integer.MAX_VALUE ? min : min + 1;
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
        
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