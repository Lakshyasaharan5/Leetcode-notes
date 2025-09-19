class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] temp = new char[s.length()];
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            temp[i] = c;
            if (c == ')') {
                if (index.size() > 0 && s.charAt(index.peek()) == '(') {
                    temp[index.pop()] = '(';                    
                } else {
                    index.push(i);
                    temp[i] = '*';
                }
            } else if (c == '(') {
                index.push(i);
                temp[i] = '*';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != '*')
                sb.append(temp[i]);
        }
        return sb.toString();
    }
}