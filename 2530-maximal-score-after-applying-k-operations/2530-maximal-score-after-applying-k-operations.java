class Solution {
    public long maxKelements(int[] nums, int k) {
        /**
                nums = [1,3,3,3,10], k = 3
   
                10/3 = 3.33

         */
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int n : nums) pq.offer(n);
        long score = 0;
        while (k-- > 0) {
            int a = pq.poll();
            score += a;
            int ceil = (int)Math.ceil((double)a/3);            
            pq.offer(ceil);
        }
        return score;
        
    }
}