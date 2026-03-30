class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int nextRoom : rooms.get(room)) {
                if (visited.add(nextRoom)) {
                    queue.offer(nextRoom);
                }
            }
        }
        return visited.size() == n;
    }
}