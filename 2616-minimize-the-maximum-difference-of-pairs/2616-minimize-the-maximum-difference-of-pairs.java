class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        int l = 0, r = max - min;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (verify(nums, p, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
        /**
                0 1 2 3 4 5 6
                1,1,2,3,4,9,9     p=2
                      ^

                a,a,xxxxxxx,b,b,b,xxxxxxx

                1,1,2,7,10
                      ^

         */        
    }

    private boolean verify(int[] nums, int pairs, int threshold) {
        int p = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (Math.abs(nums[i + 1] - nums[i]) <= threshold) {
                p++;
                i++;
            }
            if (p == pairs) return true;
        }
        return false;
    }
}