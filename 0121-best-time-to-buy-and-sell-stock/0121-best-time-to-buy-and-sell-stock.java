class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = 10001;
        for (int p : prices) {
            if (p < minPrice) {
                minPrice = p;
            } else {
                res = Math.max(res, p - minPrice);
            }
        }

        return res;
    }
}