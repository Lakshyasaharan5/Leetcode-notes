class Solution {
    public long countSubarrays(int[] nums, long k) {
        int l = 0, r = 0;
        long res = 0;
        Deque<Integer> maxq = new LinkedList<>();
        Deque<Integer> minq = new LinkedList<>();        
        while (l < nums.length) {                       
            while (r < nums.length) {                 
                while (!maxq.isEmpty() && nums[maxq.getLast()] <= nums[r]) maxq.removeLast(); 
                maxq.addLast(r);
                while (!minq.isEmpty() && nums[minq.getLast()] >= nums[r]) minq.removeLast(); 
                minq.addLast(r);
                if (((long)(nums[maxq.getFirst()] - nums[minq.getFirst()]) * (r - l + 1) > k)) break;
                r++;
            }
            res += r - l;
            l++;
            if (maxq.getFirst() < l) maxq.removeFirst();
            if (minq.getFirst() < l) minq.removeFirst();
        }
        return res;
    }
}