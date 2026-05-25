class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.size();
        int lf = 0, rf = 0;
        int majorityElem = nums.get(0);
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > rf) {
                rf = freq.get(num);
                majorityElem = num;
            }            
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == majorityElem) {
                lf++;
                rf--;
            }
            if (lf > (i + 1) / 2 && rf > (n - i - 1) / 2) return i;
        }
        return -1;
    }
}