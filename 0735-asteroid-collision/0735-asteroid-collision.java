class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int a : asteroids) {
            if (a < 0 && !st.isEmpty() && st.peek() > 0) {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -1 * a) 
                    st.pop();                
                if (!st.isEmpty() && st.peek() > 0 && st.peek() == -1 * a) {
                    st.pop();
                } else if (!st.isEmpty() && st.peek() > 0 && st.peek() > -1 * a) {
                    
                } else {
                    st.push(a);
                }
                 
            } else {
                st.push(a);
            }
        }
        int[] res = new int[st.size()];
        int k = st.size() - 1;
        while (!st.isEmpty()) {
            res[k--] = st.pop();
        }
        return res;
    }
}