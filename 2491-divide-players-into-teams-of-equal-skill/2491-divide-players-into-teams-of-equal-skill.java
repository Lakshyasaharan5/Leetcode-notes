class Solution {
    public long dividePlayers(int[] skill) {
        /**         
            [1,2,3,3,4,5]
                     
         */
        Arrays.sort(skill);
        int l = 0, r = skill.length - 1;
        int target = skill[l] + skill[r];
        long chem = 0;
        while (l < r) {
            int curr = skill[l] + skill[r];
            if (curr != target) return -1;
            chem += skill[l] * skill[r];
            l++;
            r--;
        }
        return chem;
    }
}