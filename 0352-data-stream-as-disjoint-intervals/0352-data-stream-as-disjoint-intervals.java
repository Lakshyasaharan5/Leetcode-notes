class SummaryRanges {
    /**
        [1, 4, 5, 7]
                  i

        start = 7
        end = 7

        [1] [4,5] [7]

     */
    private TreeSet<Integer> sorted;
    public SummaryRanges() {
        sorted = new TreeSet<>();
    }
    
    public void addNum(int value) {
        sorted.add(value);
    }
    
    public int[][] getIntervals() {
        if (sorted.size() == 0) return new int[][]{};
        List<int[]> intervals = new ArrayList<>();
        int start = sorted.first();
        int end = sorted.first();
        boolean skipFirst = true;
        for (int v : sorted) {
            if (skipFirst) {
                skipFirst = false;
                continue;
            }
            if (v == end + 1) {
                end = v;
            } else {
                intervals.add(new int[]{start, end});
                start = v;
                end = v;
            }
        }
        intervals.add(new int[]{start, end});

        int[][] res = new int[intervals.size()][2];
        for (int i = 0; i < intervals.size(); i++) {
            res[i][0] = intervals.get(i)[0];
            res[i][1] = intervals.get(i)[1];
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */