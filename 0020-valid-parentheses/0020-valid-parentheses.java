class Solution {    
    static HashMap<Character, Character> bracketPairs = new HashMap<>();
    static{
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
    }
    public boolean isValid(String s) {        
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