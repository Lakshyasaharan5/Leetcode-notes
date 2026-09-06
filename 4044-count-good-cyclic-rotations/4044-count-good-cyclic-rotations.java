class Solution {
    /**
        0 1 2 3 0 1 2 3
        1 2 3 4 1 2 3 4     
              -------
              i
        fh -> remove nums[i - 1], add (i + n/2 - 1) % n

        fh = 3
        sh = tot - fh = 7
        if (fh > sh) res++;

     */
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long total = 0;
        long fh = 0;
        for (int i = 0; i < n; i++) {
            if (i < n/2) fh += nums[i];
            total += nums[i];
        }
        int res = 0;
        if (fh > total - fh) res++;
        for (int i = 1; i < n; i++) {
            fh = fh - nums[i - 1] + nums[(i + n/2 - 1) % n];
            if (fh > total - fh) res++;
        }
        return res;
    }
}