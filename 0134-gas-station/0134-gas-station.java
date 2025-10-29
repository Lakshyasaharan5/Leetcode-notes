class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 2,3,1,9,9
        // 3,3,3,0,0
        //       0   
        int curr = 0, totalCost = 0, totalGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
            if (curr + gas[i] - cost[i] >= 0) {
                curr += gas[i] - cost[i];
            } else {
                start = i + 1;
                curr = 0;
            }
        }
        if (totalCost > totalGas) return -1;
        return start;
    }
}