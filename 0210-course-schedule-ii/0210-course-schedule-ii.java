class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];        
        for (int[] edge : prerequisites) {
            // [a,b] b->a
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) 
                que.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!que.isEmpty()) {
            int front = que.poll();
            res.add(front);
            if (!graph.containsKey(front)) continue;
            for (int nb : graph.get(front)) {
                indegree[nb]--;
                if (indegree[nb] == 0)
                    que.offer(nb);
            }
        }
        if (res.size() < numCourses) return new int[]{};
        int[] resArray = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            resArray[i] = res.get(i);
        return resArray;
        /**
            numCourses = 4, 
            [[1,0],[2,0],[3,1],[3,2]]
            0->1<->2
                 /^
                3 
            que = []     res = [0,3]
            indegree = [0 1 1 0]
                        0 1 2 3
         */
    }
}