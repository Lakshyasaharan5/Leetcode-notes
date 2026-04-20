class Solution {
    public double averageWaitingTime(int[][] customers) {
        int finished = 0;
        double wait = 0;
        for (int[] curr : customers) {
            finished = Math.max(finished, curr[0]);
            finished += curr[1];
            wait += finished - curr[0];
        }
        double res = (wait)/customers.length;
        return res;
    }
}