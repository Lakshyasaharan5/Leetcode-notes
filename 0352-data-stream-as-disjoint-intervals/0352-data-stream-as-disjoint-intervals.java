class SummaryRanges {
    /**
        1 2 3 4    6 7 8      10 11
    
        1 6 2 3 8 7 5 4
    
        1 : 3
        6 : 6
    
        1,8   
    
        s = 4
        e = 8  
    
    
        check upper bound and update 
        update all lower values with upper bound
    
     */
    private TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    /**
            1 : 3
            4 : 8
            
     */
    public void addNum(int value) {
        Map.Entry<Integer, Integer> smaller = map.floorEntry(value);
        Map.Entry<Integer, Integer> higher = map.ceilingEntry(value);

        if (smaller != null && smaller.getValue() >= value) {
            return;
        }

        int start = value;
        int end = value;

        if (higher != null && higher.getKey() == value + 1) {
            end = higher.getValue();
            map.remove(higher.getKey());
        }

        if (smaller != null && smaller.getValue() == value - 1) {
            map.put(smaller.getKey(), end);
            return;
        }

        map.put(start, end);

    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[index][0] = entry.getKey();
            res[index][1] = entry.getValue();
            index++;
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