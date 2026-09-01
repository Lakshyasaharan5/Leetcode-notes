class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> prev = new HashMap<>();
        for (int n : nums) {
            Map<Integer, Integer> curr = new HashMap<>();
            curr.put(n, 1);
            /**
                [9,3,1,2,6,3]
                   ^
                 3-1

                 9-1
             */
            for (Map.Entry<Integer, Integer> entry : prev.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                int x = gcd(n, key);                
                curr.put(x, curr.getOrDefault(x, 0) + value);
            }
            res += curr.getOrDefault(k, 0);
            prev = curr;
        }
        return res;
        /**
            nums = [9,3,1,2,6,3],    k = 3
                            ^
                    6-1
                    
                    2-1
                    1-4

                    gcd(curr, key) = x
                    if (x not in map) x:0
                    x += old[x]
                    
                    swap(prev,curr)
                    
                    res = 2
                    

                    {gcd -> number of subarrays}
         */
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}