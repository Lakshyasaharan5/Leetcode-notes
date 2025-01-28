class Solution {
    public int minEatingSpeed(int[] piles, int hours) {
        int maxPile = Integer.MIN_VALUE;
        for(int bananas : piles){
            maxPile = Math.max(maxPile, bananas);
        }

        int l=1, h=maxPile;
        while(l<h){
            int m = l + (h-l)/2;
            if(satisfy(m, piles, hours)){
                h=m;
            }else{
                l=m+1;
            }
        }
        return l;
    }

    boolean satisfy(int k, int[] piles, int hours){
        int count = 0;
        for(int bananas : piles){
            count += bananas/k + ((bananas%k == 0) ? 0 : 1);
        }
        return count<=hours;
    }
}