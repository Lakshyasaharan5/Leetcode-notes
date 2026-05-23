class Solution {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] indexList = new List[26];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int idx = ch - 'a';
            if (indexList[idx] == null) {
                indexList[idx] = new ArrayList<>();
            }
            indexList[idx].add(i);
        }
        int currIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            List<Integer> curr = indexList[idx];
            if (curr == null) return false;
            int nextIndex = binarySearch(curr, currIndex);
            if (nextIndex == -1) return false;
            currIndex = nextIndex;
        }
        return true;
    }

    private int binarySearch(List<Integer> curr, int currIndex) {
        int l = 0, r = curr.size() - 1;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (curr.get(m) <= currIndex) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (curr.get(r) <= currIndex) return -1;
        return curr.get(r);
    }
}