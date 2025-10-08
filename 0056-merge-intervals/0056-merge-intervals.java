class Solution {
    public int[][] merge(int[][] intervals) {
    //     [[1,3],[2,6],[8,10],[15,18]]
    //                            ^
    //  res=[[1,6], [8,10], [15,18]]
    //                         ^
    // -----------          
    //     ------
    //        ----
        //TODO: sort based on end times
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] curr = intervals[0];
        for (int[] interval : intervals) {            
            if (interval[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                merged.add(curr);
                curr = interval;
            }
        }
        merged.add(curr);
        int[][] result = new int[merged.size()][2];        
        int itr = 0;
        for (int[] interval : merged) {
            result[itr++] = interval;
        }
        return result;
    }
}