class Solution {
    /**
        ({}()){[}]
                ^
        } -> {
        ) -> (
        ] -> [

        ((((
     */
    public boolean isValid(String s) {
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put('}', '{');
        bracketsMap.put(']', '[');

        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')' || ch == '}' || ch == ']') {
                if (st.isEmpty() || st.peek() != bracketsMap.get(ch)) {
                    return false;
                }
                st.pop();
            } else {
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}