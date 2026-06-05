class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) 
            graph.put(i, new ArrayList<>());
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++)  {
            if (!preMap.containsKey(i)) {
                dfs(graph, i, preMap);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            int u = q[0], v = q[1];
            if(preMap.get(u).contains(v))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int node, Map<Integer, Set<Integer>> preMap) {    
        if (preMap.containsKey(node)) return;
        Set<Integer> curr = new HashSet<>();
        for (int nextCourse : graph.get(node)) {
            dfs(graph, nextCourse, preMap);
            curr.add(nextCourse);
            curr.addAll(preMap.get(nextCourse));
        }
        preMap.put(node, curr);
    }
}