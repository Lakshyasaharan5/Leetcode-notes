class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] buckets = new int[10001];
        for (int n : nums) {
            buckets[Math.abs(n)]++;
        }
        int[] res = new int[nums.length];
        int itr = nums.length - 1;
        for (int i = 10000; i >= 0; i--) {
            if (buckets[i] == 0) continue;
            int count = buckets[i];
            while (count-- > 0) {
                res[itr--] = i*i;
            }
        }
        return res;
    }
}