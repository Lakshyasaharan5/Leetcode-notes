class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0, maxConsecutive = 0;
        for (int n : nums) {
            if (n == 0) ones = 0;
            else ones++;
            maxConsecutive = Math.max(maxConsecutive, ones);
        }
        return maxConsecutive;
        /**
            [0]
            [1,1,0,1,1,1,0,0]
                         ^
             ones = 3
             max = 3
        */
    }
}