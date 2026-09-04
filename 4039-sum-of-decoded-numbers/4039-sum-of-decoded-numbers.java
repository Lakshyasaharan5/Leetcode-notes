class Solution {
    /**
        nums[i] = encoded -> x and y
        decoded -> x^y
        width = nums[i] % 10
        d = floor(nums[i]/10)
    
        x = d -> abcdefksdflsdjf
                 ---width---

        y = remaing of d

        nums = [231]
        w = 231 % 10 = 1
        d = 23
        x = 2, y = 3
        decoded = 8

        192 4    3

        12345 6789, 5

        5, 4
        x = n/10^4
        y = n%10^4
        Math.pow(x, y)
     */
    long MOD = 1000000007;
    public int sumDecoded(long[] nums) {        
        long sum = 0;
        for (long n : nums) {
            long width = n % 10;
            long d = n / 10;
            int numberOfDigits = getNumOfDigits(d);
            long divisor = powerOf10(numberOfDigits - (int)width);
            long x = d / divisor;
            long y = d % divisor;
            long res = binaryExponentiation(x, y);
            System.out.println(res);
            sum = (sum+res) % MOD;
        }

        return (int)sum;
    }

    private long binaryExponentiation(long x, long y) {
        long res = 1;
        for (int shift = 0; shift < 31; shift++) {
            if (((y >> shift) & 1) == 1) {
                long sq = x;
                for (int i = 0; i < shift; i++) {
                    sq = (sq*sq) % MOD;
                }
                res = (res*sq) % MOD;
            }
        }

        return res;
    }

    private long powerOf10(int exponent) {
        long res = 1;
        while (exponent-- > 0) {
            res *= 10;
        }
        return res;
    }

    private int getNumOfDigits(long a) {
        int cnt = 0;
        while (a > 0) {
            cnt++;
            a /= 10;
        }
        return cnt;
    }
}