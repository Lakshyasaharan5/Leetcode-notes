class Solution {
    /**
        0--->1<--->2
                \-->3
        
        q = []
        indegree [0 1 1 1]
                    0 1 2 3
        
        res = [0]
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) { // [a,b] b->a
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            resList.add(curr);
            for (int nb : graph.get(curr)) {
                indegree[nb]--;
                if (indegree[nb] == 0) {
                    queue.offer(nb);
                }
            }
        }
        if (resList.size() < numCourses)
            return new int[]{};
        
        int[] resArr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }
}