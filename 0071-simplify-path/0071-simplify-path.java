class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        Stack<String> st = new Stack<>();
        int i = 0, j = 0;
        while (i < n) {
            j = i;
            while (j < n && path.charAt(j) == '/')
                j++;
            i = j;
            while (j < n && path.charAt(j) != '/')
                j++;
            String curr = path.substring(i, j);
            if (curr.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else if (curr.equals(".")) {

            } else {
                if (curr.length() > 0)
                    st.push(curr);
            }
            i = j;
        }
        StringBuilder res = new StringBuilder();

        for (String directory : st) {
            res.append('/').append(directory);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}