class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int i = 0, j = 1;
        int cnt = 0;
        while (i < n) {
            if (colors[j % n] == colors[(j - 1) % n]) {
                i = j;
            }
            if (j - i + 1 == k) {
                cnt++;
                i++;
            }
            j++;
        }
        return cnt;
    }
}