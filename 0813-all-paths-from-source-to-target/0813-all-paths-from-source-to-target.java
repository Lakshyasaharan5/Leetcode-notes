class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<Integer>();
        currPath.add(0);
        dfs(graph, 0, graph.length - 1, currPath, allPaths);
        return allPaths;
    }

    private void dfs(int[][] graph, int start, int target, List<Integer> currPath, List<List<Integer>> allPaths) {
        if (start == target) {
            allPaths.add(new ArrayList<>(currPath));
            return;
        }
        for (int edge : graph[start]) {
            currPath.add(edge);
            dfs(graph, edge, target, currPath, allPaths);
            currPath.remove(currPath.size() - 1);
        }        
    }
}