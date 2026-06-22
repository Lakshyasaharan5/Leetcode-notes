class Solution {
    public String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        Stack<Character> st = new Stack<>(); // monotonically increasing
        int i = 0;
        while (i < arr.length) {
            if (st.isEmpty()) {
                st.push(arr[i++]);
                continue;
            }
            while (k > 0 && !st.isEmpty() && st.peek() > arr[i]) {
                k--;
                st.pop();
            }
            st.push(arr[i]);
            i++;
            if (k == 0) break;                        
        }
        while (i < arr.length) {
            st.push(arr[i]);
            i++;
        }
        while (k > 0 && !st.isEmpty()) {
            k--;
            st.pop();
        }
        String res = "";
        for (char ch : st) {
            res += ch;
        }
        if (res.length() == 0) return "0";
        int zeros = 0;
        while (zeros < res.length() && res.charAt(zeros) == '0') {
            zeros++;
        }
        if (zeros == res.length() && res.length() > 1) return "0";
        if (zeros == res.length()) return res;
        return res.length() == 0 ? "0" : res.substring(zeros);
    }
}