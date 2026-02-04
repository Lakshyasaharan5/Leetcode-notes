class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // Always binary search on the smaller array
        if (A.length > B.length)
            return findMedianSortedArrays(B, A);

        int m = A.length, n = B.length;
        int half = (m + n + 1) / 2;

        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = half - i;

            // i is too big
            if (i > 0 && j < n && A[i - 1] > B[j]) {
                high = i - 1;
            }
            // i is too small
            else if (j > 0 && i < m && B[j - 1] > A[i]) {
                low = i + 1;
            }
            // perfect cut
            else {
                int leftMax;
                if (i == 0) leftMax = B[j - 1];
                else if (j == 0) leftMax = A[i - 1];
                else leftMax = Math.max(A[i - 1], B[j - 1]);

                // odd length
                if ((m + n) % 2 == 1)
                    return leftMax;

                int rightMin;
                if (i == m) rightMin = B[j];
                else if (j == n) rightMin = A[i];
                else rightMin = Math.min(A[i], B[j]);

                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0; // never reached
    }
}
