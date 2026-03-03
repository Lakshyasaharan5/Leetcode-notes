class Solution {
    public int[][] merge(int[][] intervals) {
        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int longestEnd = 0;        
        int[] curr = intervals[0];
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                merged.add(curr);
                curr = interval;
            }
        }
        merged.add(curr);
        int[][] mergedArray = new int[merged.size()][2];
        int i = 0;
        for (int[] interval : merged) {
            mergedArray[i++] = interval;
        }
        return mergedArray;
    }
}