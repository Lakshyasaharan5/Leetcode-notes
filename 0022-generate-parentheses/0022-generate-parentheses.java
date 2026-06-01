class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, new StringBuilder(), res);
        return res;
    }

    private void dfs(int open, int closed, StringBuilder sb, List<String> res) {
        if (open < 0) return;
        if (open == 0 && closed == 0) {
            res.add(sb.toString());
            return;
        }
        if (open == closed) {
            sb.append('(');
            dfs(open - 1, closed, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append('(');
            dfs(open - 1, closed, sb, res);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(')');
            dfs(open, closed - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}