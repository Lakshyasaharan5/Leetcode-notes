class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1,2,3,4]
        //            post = 4
        // [1,2,6,24]
        //      i 
        // [24,12,8,6]

        int n = nums.length;
        int[] result = new int[n];
        result[0] = nums[0];
        for(int i=1; i<n; i++){
            result[i] = nums[i] * result[i-1];
        }    
        
        int post = 1;
        for(int i=n-1; i>0; i--){
            result[i] = result[i-1] * post;
            post *= nums[i];
        }
        result[0] = post;
        return result;
    }
}