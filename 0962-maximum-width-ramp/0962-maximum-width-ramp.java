class Solution {
    public int maxWidthRamp(int[] A) {
        /**
                [6,0,8,2,1,5]
                 6,0
                 8 8 8 5 5 5

                st = [6,0,2,1,5]

                [8,xxxxx,9,3,xx,4,0,0,0]
                 8  

                 8,9,9,3,3,3,3,3,4,4,0,0                  
         */
        int n = A.length;
  Stack<Integer> st = new Stack<>();
  for (int i = 0; i < n; i++) {
    if (st.empty() || A[i] < A[st.peek()]) {
      st.push(i);
    }
  }
  int ans = 0;
  for (int i = n - 1; i >= 0; i--) {
    while (!st.empty() && A[i] >= A[st.peek()]) {
      ans = Math.max(i - st.pop(), ans);
    }
  }
  return ans;
    }
}