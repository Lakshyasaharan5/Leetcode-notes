class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        long total = 0;
        for (int c : candies)
            total += c;
        if (total < k)
            return 0;
        int l = 1;
        int r = (int) Math.min(total / k, candies[candies.length - 1]);
        while (l < r) {
            int m = (r - l) / 2 + l + 1;
            if (verify(candies, k, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private boolean verify(int[] candies, long k, int m) {
        for (int i = candies.length - 1; i >= 0; i--) {
            if (candies[i] < m || k <= 0) break;
            k -= candies[i] / m;
        }
        return k <= 0;
    }
}