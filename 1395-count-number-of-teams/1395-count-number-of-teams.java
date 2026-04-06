class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;

        // ascending
        res += count(rating, true);

        // descending
        res += count(rating, false);

        return res;
    }

    private int count(int[] rating, boolean ascending) {
        int n = rating.length;
        int[][] dp = new int[n][3];

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // remaining = 1 → 2
        for (int r = 1; r <= 2; r++) {
            for (int i = n - 1; i >= 0; i--) {
                int curr = 0;

                for (int j = i + 1; j < n; j++) {
                    if ((ascending && rating[j] > rating[i]) ||
                        (!ascending && rating[j] < rating[i])) {

                        curr += dp[j][r - 1];
                    }
                }

                dp[i][r] = curr;
            }
        }

        // sum all starting points
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += dp[i][2];
        }

        return total;
    }
}