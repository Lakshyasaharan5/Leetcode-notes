class Solution {
    int[] prefix;
    Random rand = new Random();
    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i=1; i<w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int l = 0, r = prefix.length - 1;        
        int target = rand.nextInt(prefix[prefix.length - 1]) + 1;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (target > prefix[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */