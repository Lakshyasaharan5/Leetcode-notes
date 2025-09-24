class Solution {
    public int findKthPositive(int[] arr, int k) {
        //1 2 3 4 5 6 7 8 9
        //  0 1   2 3  4  5
        // [1,10,21,22,25]
        //        m
        //  l
        //     r
        if (arr[0] - 1 >= k) {
            return k;
        } 
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = (l + r) / 2 + 1;
            if (arr[m] - m - 1 < k) {
                l = m;
            } else {
                r = m - 1;
            }
        }        
        int missing = arr[l] - (l + 1);
        return arr[l] + (k - missing);
    }
}

