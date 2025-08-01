class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> {
            return (a[0] - b[0]);
        });

        List<int[]> tempResult = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }else{
                tempResult.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        tempResult.add(new int[]{start, end});

        int[][] result = new int[tempResult.size()][2];
        for(int i=0; i<tempResult.size(); i++){
            result[i][0] = tempResult.get(i)[0];
            result[i][1] = tempResult.get(i)[1];
        }

        return result;
    }
}