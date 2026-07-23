class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (verify(sum, x)) count++;
            }
        }
        return count;
        /**
                [1,100,1]        x = 1                                  
         */
    }

    private boolean verify(long sum, int x) {
        int lastDigit = (int)(sum % 10);
        int firstDigit = 0;
        while (sum > 0) {
            firstDigit = (int)(sum % 10);
            sum /= 10;
        }
        return lastDigit == x && firstDigit == x;
    }
}