class Solution {
    public int findGCD(int[] nums) {
        int min = 1001, max = -1;
        for(int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        while(min != 0){
            int rem = max % min;            
            max = min;
            min = rem;            
        }
        return max;
    }
}