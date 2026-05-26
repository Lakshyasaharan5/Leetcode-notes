class Solution {
    public int numOfSubarrays(int[] arr) {
        Map<Integer, Integer> prefixIndex = new HashMap<>();
        prefixIndex.put(0, 1);
        int prefix = 0;
        long res = 0;
        for (int n : arr) {
            prefix += n;
            int check = ((prefix % 2) + 1) % 2;
            if (prefixIndex.containsKey(check)) {
                res += prefixIndex.get(check);
            }
            int put = prefix % 2;
            prefixIndex.put(put, prefixIndex.getOrDefault(put, 0) + 1);
        }
        return (int)(res % 1_000_000_007);
    }
}