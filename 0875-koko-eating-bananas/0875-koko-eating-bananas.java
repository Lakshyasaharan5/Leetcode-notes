class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int biggestPile = 0;
        for (int pile : piles) {
            biggestPile = Math.max(biggestPile, pile);
        }
        int l = 1, r = biggestPile;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (canEat(piles, h, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean canEat(int[] piles, int h, int k) {
        int hoursTook = 0;
        for (int pile : piles) {
            hoursTook += pile/k + (pile%k > 0 ? 1 : 0);
        }
        return hoursTook <= h;
    }
}