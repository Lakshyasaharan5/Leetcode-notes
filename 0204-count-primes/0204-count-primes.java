class Solution {
    public int countPrimes(int n) {
        boolean[] composite = new boolean[n];
        int primes = 0;
        int i=2;
        while (i*i < n) {
            if (!composite[i]){            
                primes += 1;
                int j = i*i;
                while (j < n) {
                    composite[j] = true;
                    j += i;
                }
            }
            i += 1;
        }
        while (i < n) {
            if (!composite[i]) 
                primes += 1;
            i += 1;
        }
        return primes;
    }
}