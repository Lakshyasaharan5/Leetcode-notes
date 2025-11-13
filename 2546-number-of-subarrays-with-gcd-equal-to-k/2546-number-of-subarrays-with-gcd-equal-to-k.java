class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int rolling_gcd = nums[i];
            boolean found = false;
            for (int j = i; j < nums.length; j++) {
                rolling_gcd = gcd(rolling_gcd, nums[j]);
                if(rolling_gcd == k) res++;
            }            
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}