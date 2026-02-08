class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.getFirst() <= i - k) dq.removeFirst();
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[dq.getFirst()];
        }
        return res;
    }
}