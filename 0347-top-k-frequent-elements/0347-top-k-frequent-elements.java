class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create a freq map
        // push keys in min heap of size k based on values
        // create result array from min heap
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            minHeap.add(entry);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int idx = 0;
        while (!minHeap.isEmpty()){
            result[idx++] = minHeap.poll().getKey();
        }
        return result;
    }
}