class Solution {
    public int findKthLargest(int[] nums, int k) {
        // maintain min heap of size k
        // top element will be the result
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}