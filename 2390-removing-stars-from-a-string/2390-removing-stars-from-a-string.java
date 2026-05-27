class Solution {
    public String removeStars(String s) {
        int idx = 0;
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            if (ch == '*') {
                idx--;
            } else {
                arr[idx] = ch;
                idx++;
            }
        }
        return (new String(arr)).substring(0, idx);
    }
}