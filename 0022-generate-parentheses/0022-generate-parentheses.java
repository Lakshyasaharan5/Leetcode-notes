class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        List<Character> curr = new ArrayList<>();
        curr.add('(');
        dfs(n - 1, n, curr);
        return result;
    }

    private void dfs(int open, int closed, List<Character> curr) {
        if (closed < open || open < 0) return;
        if (closed == 0 && open == 0) {
            StringBuilder sb = new StringBuilder();
            for (char ch : curr) {
                sb.append(ch);
            }
            result.add(sb.toString());
        }
        curr.add('(');
        dfs(open - 1, closed, curr);
        curr.remove(curr.size() - 1);

        curr.add(')');
        dfs(open, closed - 1, curr);
        curr.remove(curr.size() - 1);
    }
}