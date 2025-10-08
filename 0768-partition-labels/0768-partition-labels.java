class Solution {
    public List<Integer> partitionLabels(String s) {
        // 0 1 2 3 4 5
        // a b a c d e
        //           ^
        //           p
        // breakpoint = 2
        // a:2
        // b:1
        // c:3
        // e:5
        int[] indexMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            indexMap[s.charAt(i) - 'a'] = i;
        }
        int breakpoint = 0;
        int prev = -1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            breakpoint = Math.max(breakpoint, indexMap[s.charAt(i) - 'a']);
            if (i == breakpoint) {                
                res.add(breakpoint - prev);
                prev = breakpoint;
            }
        }
        return res;
    }
}