class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // find min removals using stack
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') st.push(c);
            if (c == ')') {
                if (!st.isEmpty() && st.peek() == '(') 
                    st.pop();
                else
                    st.push(c);
            }
        }
        int minRemove = st.size();
        
        // generate valid parantheses using backtrack after removals
        Set<String> permutations = new HashSet<>();
        List<Character> tmp = new ArrayList<>();
        backtrack(s, 0, tmp, permutations, minRemove);
        
        // final pick the valid strings and put in the result
        List<String> result = new ArrayList<>();
        for (String perm : permutations) {
            if (isValid(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private void backtrack (String s, int start, List<Character> tmp, Set<String> permutations, int minRemove) {
        if (tmp.size() == s.length() - minRemove) {
            StringBuilder sb = new StringBuilder();
            for (char c : tmp) {
                sb.append(c);
            }
            permutations.add(sb.toString());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            tmp.add(s.charAt(i));
            backtrack(s, i + 1, tmp, permutations, minRemove);
            tmp.remove(tmp.size() - 1);
        }
    }

    private boolean isValid(String perm) {
        Stack<Character> st = new Stack<>();
        for (char c : perm.toCharArray()) {
            if (c == '(') st.push(c);
            if (c == ')') {
                if (!st.isEmpty() && st.peek() == '(') 
                    st.pop();
                else
                    st.push(c);
            }
        }
        return st.isEmpty();
    }
}