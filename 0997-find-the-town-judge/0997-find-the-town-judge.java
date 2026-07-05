class Solution {
    public int findJudge(int n, int[][] trust) {
        /**
            n = 3
            trust = [[1,3],[2,3],[3,1]]
            trustedBy map
            3: 1, 2
            1: 3
        */
        if (n == 1) return n;
        Map<Integer, List<Integer>> trustedBy = new HashMap<>();
        Set<Integer> normalPeople = new HashSet<>();
        for (int[] t : trust) {
            int u = t[0], v = t[1]; //v: [u]
            trustedBy.computeIfAbsent(v, (k) -> new ArrayList<>()).add(u);            
            normalPeople.add(u);
        }
        for (int i = 1; i <= n; i++) {
            if (trustedBy.containsKey(i) && 
                trustedBy.get(i).size() == n - 1 &&
                !normalPeople.contains(i)
            )
                return i;
        }
        return -1;
    }
}