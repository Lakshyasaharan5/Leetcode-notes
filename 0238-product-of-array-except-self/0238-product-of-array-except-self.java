class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
            [-1,1,0,-3,3]
                       ^p=0              
             [0,0,0,-9,3]

             if (i == len - 1) res[i] = p
             else res[i] = p * res[i+1]
             p *= nums[i]                       
         */
        int N = nums.length;
        int[] res = new int[N];
        res[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            res[i] = nums[i] * res[i + 1];
        }
        int prefix = 1;
        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                res[i] = prefix;
            } else {
                res[i] = prefix * res[i + 1];
            }
            prefix *= nums[i];
        }
        return res;
    }
}