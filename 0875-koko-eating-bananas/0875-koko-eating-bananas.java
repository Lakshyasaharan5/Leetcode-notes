class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Integer.MIN_VALUE;
        for (int bananas : piles) {
            maxPile = Math.max(maxPile, bananas);
        }
        int l = 1, r = maxPile;
        while (l < r) {
            int m = (r - l)/2 + l;
            if (canEat(piles, h, m)){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
        /**
            [3,6,7,11], h = 8

            0 1 2 3 4 5 6 7  8        
            3 4 5 6 7 8 9 10 11
            l-----------------r
            r = m
            l = m+1        
         */
    }

    private boolean canEat(int[] piles, int h, int k) {
        int hours = 0;
        for (int bananas : piles) {
            hours += bananas/k + (bananas % k > 0 ? 1 : 0);
        }
        return hours <= h;
    }
}