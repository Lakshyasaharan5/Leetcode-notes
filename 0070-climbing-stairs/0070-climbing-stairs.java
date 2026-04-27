class Solution {
    public int climbStairs(int n) {
        // [2 1 1 0 0]
        //  0 1 2 3 4
        //    c a b
        //    c = a + b
        //    b = a
        //    a = c
        int a = 1, b = 0;
        while (n-- > 0) {
            int c = a + b;
            b = a;
            a = c;
        }
        return a;
        //            0
        //          /   \
        //         1     2
        //       /   \
        //      2     3 
        //     / \
        //    3   4 
        
    }
}