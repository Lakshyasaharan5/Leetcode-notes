class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();        
        Set<Integer> visited = new HashSet<>();        
        dfs(rooms, 0, visited);
        return visited.size() == n;
    }   

    private void dfs(List<List<Integer>> rooms, int currRoom, Set<Integer> visited) {
        if (visited.contains(currRoom)) return;
        visited.add(currRoom);
        for (int nextRoom : rooms.get(currRoom)) {
            dfs(rooms, nextRoom, visited);
        }
    }
}