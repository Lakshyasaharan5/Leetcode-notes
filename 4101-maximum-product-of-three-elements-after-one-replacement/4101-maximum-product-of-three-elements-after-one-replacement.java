class Solution {
    public long maxProduct(int[] nums) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>(); // largest 3
        for (int n : nums) {
            minHeap.add((long)Math.abs(n));
            if (minHeap.size() > 2) minHeap.poll();
        }
        return 100000 * minHeap.poll() * minHeap.poll();
    }
}