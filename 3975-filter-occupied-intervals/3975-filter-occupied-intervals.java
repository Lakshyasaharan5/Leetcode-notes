class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int l, int r) {
        Arrays.sort(occupiedIntervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> merged = new ArrayList<>();
        int end = occupiedIntervals[0][1];
        int start = occupiedIntervals[0][0];
        for (int[] interval : occupiedIntervals) {
            start = Math.min(start, interval[0]);
            if (interval[0] - end <= 1) {
                end = Math.max(end, interval[1]);
            } else {
                merged.add(new ArrayList<>(Arrays.asList(start, end)));
                start = interval[0];
                end = interval[1];
            }
        }
        merged.add(new ArrayList<>(Arrays.asList(start, end)));
        System.out.println(merged);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> interval : merged) {
            int curr_l = interval.get(0);
            int curr_r = interval.get(1);            
            if ((curr_l <= l && l <= curr_r) || (curr_l <= r && r <= curr_r)) {
                if ((curr_l <= l && l <= curr_r) && (curr_l <= r && r <= curr_r)) {
                    if (curr_l < l) {
                        res.add(new ArrayList<>(Arrays.asList(curr_l, l - 1)));
                    }
                    if (r < curr_r) {
                        res.add(new ArrayList<>(Arrays.asList(r + 1, curr_r)));
                    }
                } else if (curr_l < l) {
                    res.add(new ArrayList<>(Arrays.asList(curr_l, l - 1)));
                } else if (r < curr_r) {
                    res.add(new ArrayList<>(Arrays.asList(r + 1, curr_r)));
                }
            } else {
                if ((l <= curr_l && curr_r <= r)) {
                    continue;
                }   
                res.add(new ArrayList<>(Arrays.asList(curr_l, curr_r)));
            }
        }
        return res;
        /*
            if l or r
                if l and r 
                    if curr_l < l
                        [curr_l,l - 1] 
                    if curr_r > r
                        [r + 1,curr_r]
                if l
                    if curr_l < l
                        [curr_l,l - 1] 
                if r
                    if curr_r > r
                        [r + 1,curr_r]
        
        
                [[2,6],[4,8],[10,12],[10,10],[14,16]]
                    ^
                    s=2
                    e=6
                [[2,8],[10,12],[14,16]]
                 [7,11]
        
        
                     ---
                ----- -------- -------
                123456789
        
        */        
    }
}