class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int curr, Set<Integer> visited) {
        if (visited.contains(curr)) return;
        visited.add(curr);
        for (int nextRoom : rooms.get(curr)) {
            dfs(rooms, nextRoom, visited);
        }
    }
}