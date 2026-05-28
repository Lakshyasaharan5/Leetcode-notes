class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int idx = binarySearch(potions, spells[i], success);
            pairs[i] = (idx < 0) ? 0 : potions.length - idx;
        }
        return pairs;
    }

    private int binarySearch(int[] potions, int spell, long success) {
        int l = 0, r = potions.length - 1;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if ((long)potions[m] * spell < success) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if ((long)potions[l] * spell < success) return -1;
        return l;
    }
}