class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // {1:3, 2:1, 3:4}
        // [1,3],[3,4]
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        freq.forEach((key,val) -> {
            pq.add(new int[]{key,val});
            if (pq.size() > k) pq.poll();
        });
        int[] result = new int[pq.size()];
        int idx = 0;
        while (!pq.isEmpty()) {
            result[idx++] = pq.poll()[0];
        }
        return result;
    }
}