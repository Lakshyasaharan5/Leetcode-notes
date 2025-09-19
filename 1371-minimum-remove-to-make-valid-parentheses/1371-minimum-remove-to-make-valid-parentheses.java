class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        boolean[] remove = new boolean[n]; // flags for chars to remove
        int[] stack = new int[n];          // manual stack for '(' indices
        int top = -1;

        // First pass: mark invalid ')' and track '('
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack[++top] = i; // push index of '('
            } else if (c == ')') {
                if (top >= 0) {
                    top--; // match found, pop
                } else {
                    remove[i] = true; // unmatched ')'
                }
            }
        }

        // Second pass: any '(' left in stack are unmatched
        while (top >= 0) {
            remove[stack[top--]] = true;
        }

        // Build final string
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (!remove[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
