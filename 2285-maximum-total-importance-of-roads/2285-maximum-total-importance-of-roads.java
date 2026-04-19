class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] edge : roads) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Arrays.sort(degree);
        long res = 0;
        int value = 1;
        for (int d : degree) {
            res += (long)d * value++;
        }
        return res;
    }
}