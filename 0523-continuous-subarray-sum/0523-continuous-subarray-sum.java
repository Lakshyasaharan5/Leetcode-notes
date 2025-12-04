class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (prefix.containsKey(rem) && (i - prefix.get(rem)) >= 2) return true;
            else prefix.putIfAbsent(rem, i);
        }
        return false;
    }
}