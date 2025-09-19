class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracketPairs.containsKey(bracket)) {
                if (bracketStack.isEmpty() || bracketStack.pop() != bracketPairs.get(bracket)) {
                    return false;
                }
            } else {
                bracketStack.push(bracket);
            }
        }                
        return bracketStack.isEmpty();
    }
}