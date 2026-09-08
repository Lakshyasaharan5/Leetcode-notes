class Solution {
    /**
        sum of min(b)
        b -> from every subarray

        sum(min from all subarrays)

        0 1 2 3
        3,1,2,4
              i
        [1,2]

        xxxxx2xxx4xxxxxxxxxxx9

        0 1 2
        2 4 9        
            i
        [0,1,2]
        min = 2, [4,2], [9,4,2]

        [2 6 15]
         0 1 2

         0 1 2 3
         3,1,2,4
               i
         min = [3], [1,1], [2,1,1], [4,4]
         stack = [1,2]

         dp = [3 2 4 8]
               0 1 2 3

        monotonic increasing stack
        pop until top >= curr element
        look at top of stack
            dp[curr] = [curr index - top + 1] * curr element + dp[top]
        else
            dp[curr] = [curr index + 1] * curr element

        st.push(curr index)

        return sum(dp)
     */
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int N = arr.length;
        Stack<Integer> st = new Stack<>();
        long[] dp = new long[N];
        /**
                    0 1 2 3
                    3,1,2,4
                          i
                    stack = [1,2]

                  dp = [3 2 4 0]
                        0 1 2 3
         */
        for (int i = 0; i < N; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                dp[i] = (long)(i - st.peek()) * (long)arr[i] + dp[st.peek()];
            } else {
                dp[i] = (long)(i + 1) * (long)arr[i];
            }
            st.push(i);
        }

        long res = 0;
        for (long currSum : dp) {
            res = (res + currSum) % MOD;
        }

        return (int)res;
    }
}