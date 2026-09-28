class Solution {
    /**
        [1,1,1,2,2,3], k = 2

        1: 3
        2: 2
        3: 1
    
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return freq.get(a) - freq.get(b);
        });
        for (int key : freq.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        int itr = 0;
        while (!pq.isEmpty()) {
            res[itr++] = pq.poll();
        }
        return res;
    }
}