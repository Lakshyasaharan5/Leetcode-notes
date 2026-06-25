class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total = 0, maxValue = Integer.MIN_VALUE;
        for (int  w : weights) {
            total += w;
            maxValue = Math.max(maxValue, w);
        }

        //binary search
        int l = maxValue, r = total;
        while (l < r) {            
            int m = (r - l) / 2 + l;
            if (verify(weights, days, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    boolean verify(int[] weights, int days, int cap) {
        int curr = 0;
        for (int i = 0; i < weights.length; i++) {
            curr += weights[i];
            if (curr > cap) {
                days--;
                curr = weights[i];
            }
        }
        days--;        
        return days >= 0;
    }
}