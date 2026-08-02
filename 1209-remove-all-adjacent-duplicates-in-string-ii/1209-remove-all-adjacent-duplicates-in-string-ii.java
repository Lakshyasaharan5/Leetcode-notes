class Solution {
    public String removeDuplicates(String s, int k) {
        /**
                deeedbbcccbdaa
                a1a2
                ^
        */
        Stack<Pair<Character, Integer>> st = new Stack<>();
        st.push(new Pair<>(s.charAt(0), 1));
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (st.isEmpty()) {
                st.push(new Pair<>(currChar, 1));
                continue;
            }
            char topChar = st.peek().getKey();
            int topValue = st.peek().getValue();
            if (currChar == topChar) {
                st.push(new Pair<>(currChar, topValue + 1));
            } else {
                st.push(new Pair<>(currChar, 1));
            }
            if (st.peek().getValue() == k) {
                for (int j = 0; j < k; j++)
                    st.pop();
            }
        }
        String res = "";
        while (!st.isEmpty()) {
            res = st.pop().getKey() + res;
        }
        return res;
    }
}