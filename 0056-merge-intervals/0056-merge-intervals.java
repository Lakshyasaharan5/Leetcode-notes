class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> mergedList = new ArrayList<>();
        int[] curr = intervals[0];
        for (int[] interval : intervals) {
            if (curr[1] >= interval[0]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                mergedList.add(curr);
                curr = interval;
            }
        }
        mergedList.add(curr);
        int[][] res = new int[mergedList.size()][2];
        for (int i = 0; i < mergedList.size(); i++) {
            res[i] = mergedList.get(i);
        }
        return res;
    }
}