class Solution {
    public boolean divisorGame(int n) {
        /**
                4
            1       2      alice
           none     1      bob
                    none   alice

                    [w]
                  w     w
                l  w   w  w
            
            for i in range (0 to n)
                if dfs(n - i)
                    return true
            return false

                        alice
                l l w l w w l l 
            [l l w w w l]
             0 1 2 3 4 5

            for i in (0 to n)
                if n%i and dp[n - i] == lose
                    dp[i] = win
            
         */
        if (n < 2) return false;

        boolean[] dp = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }                    
            }
        }
        return dp[n];

        // for (int i = 1; i < n; i++) {
        //     if (n % i == 0 && !divisorGame(n - i))
        //         return true;
        // }
        // return false;
    }
}