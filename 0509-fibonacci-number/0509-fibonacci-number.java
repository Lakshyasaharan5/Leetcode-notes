class Solution {
    public int fib(int n) {
        /**
                3
              2    1
            1  0
            [0 0 0 0 0 ]
            0 1 1
            a b c
            c = a+b
            a = b
            b = c
         */
        if (n < 2) return n;
        int a = 0, b = 1, c = 1;
        while (n-- > 1) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}