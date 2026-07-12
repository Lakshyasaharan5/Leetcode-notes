class Solution {
    public int majorityElement(int[] nums) {
        /**
            [3,2,3]
                 ^
            curr = 2
            cnt = 0
            []

        */
        int curr = nums[0];
        int cnt = 0;
        for (int n : nums) {
            if (curr == n) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt <= 0) {
                cnt = 1;
                curr = n;
            }
        }
        return curr;
    }
}