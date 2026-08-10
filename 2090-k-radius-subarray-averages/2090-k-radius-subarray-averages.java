class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = (long)nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (long)nums[i];
        }
        long rollingSum = 0;
        for (int i = 0; i < n; i++) {            
            if (i - k < 0 || i + k >= n) {
                rollingSum += nums[i];
                prefix[i] = -1;
                continue;
            }
            rollingSum += nums[i];
            prefix[i] = (rollingSum + prefix[i + k] - prefix[i])/(2*k + 1);
            rollingSum -= nums[i - k];

        }    
        int[] res = new int[n];
        for (int i =0; i < n; i++) res[i] = (int)prefix[i];    
        return res;
        /**
                 7,4,3,9,1,21,13,8,6            
                [7,4,3,9,1,8, 5, 2,6], k = 3
                           i

                       if i-k >=0:
                            add a[i]
                            add prefix[i+k] - prefix[i] (i+k < len)
                            total avg
                            remove a[i-k]
                         
         */
    }
}