class Solution {

    /**
        [1,3,4,1]
        [1,2,2,2,3,3,3,3,4]

        [1 2]
         1 3

         1 2 2 
         1 3 5

         1 2 3 4 5 

         1/5 2/5 2/5

         1 4 9   9
         1 5 14  23

        0 -> 1
        1 -> 2,3,4,5
        2 -> 6,7,8,9,10,11,12,13,14

        [1 5 14, 23]
         0 1  2   3

         random(1,sum)
         scan prefix sum 
            pick index which is greater or equal to random

        

     */
    int[] prefixSum;
    int total = 0;
    Random r;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }      
        total = prefixSum[prefixSum.length - 1];
        r = new Random();
    }
    
    public int pickIndex() {
        int randomNumber = r.nextInt(1, total + 1);
        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixSum[i] >= randomNumber) {
                return i;
            }
        }
        return prefixSum.length - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */