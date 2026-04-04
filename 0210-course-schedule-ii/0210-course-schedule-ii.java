class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // b -> a pre[a,b]
        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for (int course = 0; course < n; course++) {
            if (!dfs(graph, course, visiting, visited, stack)) {
                return new int[]{};
            }
        }
        int[] plan = new int[stack.size()];
        int k = 0;
        while (!stack.isEmpty()) {
            plan[k++] = stack.pop();
        }
        return plan;
    }

    private boolean dfs(List<Integer>[] graph, int course, Set<Integer> 
                        visiting, Set<Integer> visited, Stack<Integer> stack) {
        if (visited.contains(course)) {
            return true;
        }
        if (visiting.contains(course)) {
            return false;
        }
        visiting.add(course);
        for (int nextCourse : graph[course]) {
            if (!dfs(graph, nextCourse, visiting, visited, stack)) {
                return false;
            }
        }
        visiting.remove(course);
        visited.add(course);
        stack.push(course);
        return true;
    }
}