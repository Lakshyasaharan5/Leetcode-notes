class Solution {
    public int maxFrequency(int[] nums, int k) {
        int kFreq = 0;
        for (int n : nums) {
            if (n == k) kFreq++;
        }
        int maxSubstitute = 0;
        for (int i = 1; i <= 50; i++) {
            if (i == k) continue;
            int curr = 0, maxCurr = 0;
            for (int n : nums) {
                if (n == i) curr++;
                if (n == k) curr--;
                if (curr < 0) curr = 0;
                maxCurr = Math.max(maxCurr, curr);
            }
            maxSubstitute = Math.max(maxSubstitute, maxCurr);
        }
        return kFreq + maxSubstitute;
    }
}