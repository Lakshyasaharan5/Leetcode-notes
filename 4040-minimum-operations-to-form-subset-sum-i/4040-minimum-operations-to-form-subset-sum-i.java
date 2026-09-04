class Solution {
    /**
        nums, sum
        x -> 2*x or floor(x/2)
        mul before div operation

        min ops -> subset sum == sum

        nums = [5,6,10], sum = 4

        5 - (5,0), (2,1), (1,2)
        6 - (6,0), (3,1), (1,2)
       10 - (10,0), (5,1), (2,2), (1,3)

                    2,1 - 1,2 - 1,3 cost=6
                    1,2 - 3,1 cost=3
                    1,2 - 1,2 - 2,2 cost=6

        2,1   1,2
        3,1   1,2
        2,2   1,3

           x,4                          (2,1),2                     (1,2),3
    (3,1),1  (1,2),3.  x,4         (3,1),-1   (1,2),0         (3,1),0     (1,2),2
 (2,2),-1  (1,3),0 ......  


                    (2,1)   (1,2)      sum=2
                    (2,2)   (1,3)
                    (2,1)
      
            x,2                        (2,1),0                      (1,2),1
x,2     (2,2),0    (1,3),1                                     x,1   (2,2),-1     (1,3),0
(2,1),0

                for (i-> start to len):
                    int returnValue = dfs
                    if returnValue == inf: continue;
                    pick = min(returnValue + currCost)

                skip = (dfs)

                return min(pick, skip)                
 
            O(2^n * log(sum))

     */
    public int minOperations(int[] nums, int sum) {
        int[][] dp = new int[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(nums, 0, sum, dp);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private int dfs(int[] nums, int i, int sum, int[][] dp) {
        if (sum == 0) return 0;
        if (i >= nums.length || sum < 0) return Integer.MAX_VALUE;
        if (dp[i][sum] != -1) return dp[i][sum];

        int num = nums[i];
        int cost = 0;
        int pick = Integer.MAX_VALUE;

        // no operation
        int returnValue = dfs(nums, i + 1, sum - nums[i], dp);
        if (returnValue != Integer.MAX_VALUE)            
            pick = Math.min(pick, returnValue);

        // multiply        
        while (num <= sum) {
            cost++;
            num *= 2;
            returnValue = dfs(nums, i + 1, sum - num, dp);
            if (returnValue == Integer.MAX_VALUE)
                continue;
            pick = Math.min(pick, returnValue + cost);
        }

        // divide
        num = nums[i];
        cost = 0;     
        while (num > 0) {
            cost++;
            num /= 2;
            returnValue = dfs(nums, i + 1, sum - num, dp);
            if (returnValue == Integer.MAX_VALUE)
                continue;
            pick = Math.min(pick, returnValue + cost);
        }   



        // skip
        int skip = dfs(nums, i + 1, sum, dp);

        return dp[i][sum] = Math.min(pick, skip);
    }
}