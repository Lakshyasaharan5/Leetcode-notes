class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Set<Integer> locked = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int ib : initialBoxes) {
            if (status[ib] == 1) {
                queue.offer(ib);
            } else {
                locked.add(ib);
            }
        }
        int candiesFound = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            candiesFound += candies[curr];
            // collect keys
            for (int k : keys[curr]) {
                status[k] = 1;
                if (locked.contains(k)) {
                    queue.offer(k);
                    locked.remove(k);
                }
            }
            // collect boxes
            for (int nextBox : containedBoxes[curr]) {
                if (status[nextBox] == 0) {
                    locked.add(nextBox);
                } else {
                    queue.offer(nextBox);
                }
            }
        }
        return candiesFound;
    }
}