class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : arr) freq.put(a, freq.getOrDefault(a, 0) + 1);
        List<int[]> list = new ArrayList<>();
        for (int key : freq.keySet()) {
            list.add(new int[]{key, freq.get(key)});
        }
        list.sort((a, b) -> a[1] - b[1]);
        int i = 0;
        while (i < list.size() && k > 0) {
            int[] curr = list.get(i);
            k -= curr[1];
            i++;
        }
        if (k < 0) {
            return list.size() - i + 1;
        }
        return list.size() - i;
    }
}