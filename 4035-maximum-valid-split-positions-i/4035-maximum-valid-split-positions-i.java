class Solution {
    /**
         0  1  2  3
        10,30,15,10         

        10 10  5  5
         5  5  5 10
        
    */
    public int maxValidSplits(int[] nums) {
        int res = Integer.MIN_VALUE;

        // try the full array
        res = Math.max(res, score(nums));

        // return if len <= 2
        if (nums.length <= 2) {
            return res;
        }

        int[] premain = new int[nums.length];
        premain[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            premain[i] = gcd(premain[i - 1], nums[i]);
        }

        // try removing each index
        for (int skip = 0; skip < nums.length; skip++) {
            if (skip > 0 && premain[skip] == premain[skip - 1]) continue;
            int[] temp = new int[nums.length - 1];
            int idx = 0;
            for (int i = 0; i < nums.length; i++) {                
                if (i == skip) continue;
                temp[idx++] = nums[i];
            }
            res = Math.max(res, score(temp));
        }

        return res;
    }

    private int score(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int rollingGcd = 0;
        for (int i = 0; i < n; i++) {
            rollingGcd = gcd(rollingGcd, arr[i]);
            prefix[i] = rollingGcd;
        }
        rollingGcd = 0;
        for (int i = n - 1; i >= 0; i--) {
            rollingGcd = gcd(rollingGcd, arr[i]);
            suffix[i] = rollingGcd;
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] == suffix[i + 1])
                count++;
        }
        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int mod = a%b;
            a = b;
            b = mod;
        }
        return a;
    }
}