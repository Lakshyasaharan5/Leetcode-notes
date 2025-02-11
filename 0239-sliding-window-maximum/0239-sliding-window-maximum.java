class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(0);
        for(int i=1; i<k; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
                dq.removeLast();
            dq.addLast(i);
        }
        int idx = 0;
        result[idx++] = nums[dq.peekFirst()];

        int l=1, r=k;
        while(r < nums.length){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[r])
                dq.removeLast();
            dq.addLast(r);
            if(dq.peekFirst() < l)
                dq.removeFirst();
            result[idx++] = nums[dq.peekFirst()];
            l++;
            r++;
        }
        return result;
    }
}