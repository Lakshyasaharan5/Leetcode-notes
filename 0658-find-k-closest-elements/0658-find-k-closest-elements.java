class Solution {
    /**
         0 1 2  3   4
        [1,2,3,400,500],     k = 3, x = 3
             m
         l
                     r
         ---

        1 2 3 3 3 3 7000
                    7000
                

        x    m...m+k 
        x is on left side so we move r=m

        m...m+k   x
        x is on right side so we move l=m+1

        m.....x.....m+k
        x is in between so just compare as usual
        m..x.........m+k -> r=m      
        m.........x..m+k -> l=m+1
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length == 0) return new ArrayList<>();
        int n = arr.length;
        int l = 0, r = n - k;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}