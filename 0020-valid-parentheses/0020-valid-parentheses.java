class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char b = s.charAt(i);
            if (bracketsMap.containsKey(b)) {
                if (st.isEmpty() || st.peek() != bracketsMap.get(b)) return false;
                st.pop();
            } else {
                st.push(b);
            }
        }
        return st.isEmpty();
    }
}