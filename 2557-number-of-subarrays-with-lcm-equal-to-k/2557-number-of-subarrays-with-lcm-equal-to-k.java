class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int res = 0;
        for(int i=0; i<nums.length; i++){
            int lcm = nums[i];
            for(int j=i; j<nums.length; j++){
                if (lcm > k || k % lcm != 0) break;
                lcm = getLCM(lcm, nums[j]);
                if(lcm == k) res++;
            }
        }
        return res;
    }

    private int getLCM(int a, int b){
        return a/getGCD(a,b) * b;
    }

    private int getGCD(int a, int b) {
        if (a==0) return b;
        return getGCD(b%a, a);
    }
}