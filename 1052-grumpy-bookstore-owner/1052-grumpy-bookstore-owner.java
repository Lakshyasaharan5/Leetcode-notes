class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 1,0,1,2,1,1,7,5
        // 0,1,0,1,0,1,0,1     minutes = 3
        //      l---r
        // 1 1 2 2 3 3 10 10
        int n = customers.length;
        int[] satisfiedPrefix = new int[n];
        satisfiedPrefix[0] = (grumpy[0] == 0 ? customers[0] : 0);
        int[] prefixSum = new int[n];
        prefixSum[0] = customers[0];
        for (int i = 1; i < n; i++) {
            satisfiedPrefix[i] = satisfiedPrefix[i - 1] + (grumpy[i] == 0 ? customers[i] : 0);
            prefixSum[i] = prefixSum[i - 1] + customers[i];
        }
        int l = 0, r = minutes - 1;
        int res = Integer.MIN_VALUE;
        while (r < n) {
            int curr = (l > 0 ? satisfiedPrefix[l - 1] : 0) + prefixSum[r] - (l > 0 ? prefixSum[l - 1] : 0) + (r < n - 1 ? satisfiedPrefix[n - 1] - satisfiedPrefix[r] : 0);
            res = Math.max(res, curr);
            l++;
            r++;
        }
        return res;
    }
}