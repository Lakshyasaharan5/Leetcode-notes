class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int prefix = 0;
        int res = 0;
        for (int n : nums) {
            prefix += n;
            int curr = ((prefix % k) + k) % k;
            if(mpp.containsKey(curr)) res += mpp.get(curr);
            mpp.put(curr, mpp.getOrDefault(curr, 0) + 1);
        }
        return res;        
    }
}