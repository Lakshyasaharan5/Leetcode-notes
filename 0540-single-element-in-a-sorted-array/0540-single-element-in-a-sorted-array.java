class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (m % 2 == 0) {
                if (arr[m] == arr[m + 1]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            } else {
                if (arr[m] == arr[m - 1]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }
        return arr[l];
    }
}