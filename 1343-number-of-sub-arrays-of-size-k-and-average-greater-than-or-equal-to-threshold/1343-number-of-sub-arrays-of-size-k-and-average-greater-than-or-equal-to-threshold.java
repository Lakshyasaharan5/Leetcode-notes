class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        threshold *= k;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i + 1 >= k) {
                if (sum >= threshold) res++;
                sum -= arr[i - k + 1];
            }
        }
        return res;
    }
}