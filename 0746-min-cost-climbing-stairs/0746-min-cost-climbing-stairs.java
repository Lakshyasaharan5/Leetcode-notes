class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // [1 1 2 0 0]
        //  0 1 2 3 4
        int a = 0, b = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int c = Math.min(a, b) + cost[i];
            b = a;
            a = c;
        }
        return Math.min(a, b);
    //          0
    //        /   \
    //       1     2
    //     /   \
    //    2     3
    //   / \
    //  3   4
    }
}