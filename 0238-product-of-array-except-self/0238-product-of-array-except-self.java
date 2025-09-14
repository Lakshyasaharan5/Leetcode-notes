class Solution {
    public int[] productExceptSelf(int[] nums) {
        // create a postfix product array 
        // keep a prefix product variable
        // traverse nums and keep updating the postfix array as prefix * postfix[i+1]
        int n = nums.length;
        int[] res = new int[n];
        res[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--){            
            res[i] = res[i + 1] * nums[i];
        }
        int prefix = 1;
        for (int i = 0; i < n - 1; i++){
            res[i] = res[i + 1] * prefix;
            prefix *= nums[i];
        }
        res[n - 1] = prefix;
        return res;
    }
}