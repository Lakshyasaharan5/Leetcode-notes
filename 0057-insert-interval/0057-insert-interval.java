class Solution {
    /**
        intervals = [[3,5],   [6,7],[8,10],[12,16]], newInterval = [7,8]
                                             i
                                     ---       

            start

     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();  
        int[] ptr = newInterval;      
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // comes before
            if (ptr[1] < curr[0]) {
                res.add(ptr);
                ptr = curr;
            }

            // overlap
            else if (ptr[0] <= curr[1]) {
                ptr = new int[]{Math.min(ptr[0], curr[0]), Math.max(ptr[1], curr[1])};
            }

            // ahead
            else {
                res.add(curr);
            }
        }

        res.add(ptr);
        
        return res.toArray(new int[res.size()][2]);
    }
}