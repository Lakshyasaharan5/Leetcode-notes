class Solution {
    public int maxFrequency(int[] nums, int k) {
        int freqK = 0;
        for (int n : nums) {
            if (n == k) freqK++;
        }
        int res = 0;
        for (int i = 1; i <= 50; i++) {
            //kadane for i
            int maxFreq = 0, curr = 0;
            for (int n : nums) {
                if (n == i) curr++;
                if (n == k) curr--;
                if (curr < 0) curr = 0;
                maxFreq = Math.max(maxFreq, curr);
            }
            res = Math.max(res, maxFreq + freqK);
        }
        return res;
    }
}