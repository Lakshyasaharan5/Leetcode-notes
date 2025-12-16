class Solution {
    public int reverse(int x) {
        long res = 0;
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x *= -1;
        }
        while (x > 0) {
            res = res*10 + x%10;
            x /= 10;
        }
        if (isNeg) {
            res *= -1;
        }
        if (res > (int)(Math.pow(2,31)-1) || res < -1*(int)Math.pow(2,31)) return 0;
        return (int)res;
    }
}