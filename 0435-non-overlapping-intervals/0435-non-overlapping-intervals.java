class Solution {
    /**
        -----------
        ----
            ---
            -------

        [1,10],[1,5],[2,6],[5,10]
                             i
           end = 5 
           removed = 2

            sort based on start time      
            keep curr end and remove longest                     
            

     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals[0][1];
        int removed = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < end) {
                removed++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return removed;
    }
}