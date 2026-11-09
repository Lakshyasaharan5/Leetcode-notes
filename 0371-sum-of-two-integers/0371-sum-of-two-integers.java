class Solution {
    /**
            0001
            0010
     */
    public int getSum(int a, int b) {
        int loop = (1 << 30);
        int res = 0;
        while (loop > 0) {
            int temp_a = a ^ b;
            int temp_b = (a & b) << 1;
            res = temp_a ^ temp_b;
            a = temp_a;
            b = temp_b;
            loop = loop >> 1;
        }
        return res;
    }
}