class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0){
            return true;
        }

        // convert to adjacency list
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int[] edge : prerequisites){
            int course = edge[0];
            int prereq = edge[1];
            if (!adj.containsKey(prereq)){
                adj.put(prereq, new ArrayList<>());
            }
            if (!adj.containsKey(course)){
                adj.put(course, new ArrayList<>());
            }
            adj.get(prereq).add(course);
        }
        // System.out.println(adj.toString());

        // create indegrees
        Map<Integer, Integer> indegree = new HashMap<>();
        for(int[] edge : prerequisites){
            int course = edge[0];
            int prereq = edge[1];
            indegree.putIfAbsent(course, 0);
            indegree.putIfAbsent(prereq, 0);
            indegree.put(course, indegree.get(course) + 1);
        }
        // System.out.println(indegree.toString());

        // bfs
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : indegree.entrySet()){
            if (entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }
        List<Integer> coursesTaken = new ArrayList<>();
        while (q.size() > 0){
            int course = q.poll();
            coursesTaken.add(course);

            if (coursesTaken.size() >= numCourses){
                return true;
            }

            for(int prereq : adj.get(course)){
                indegree.put(prereq, indegree.get(prereq) - 1);
                if (indegree.get(prereq) == 0){
                    q.add(prereq);
                }
            }
        }

        int totalPre = indegree.keySet().size();
        return coursesTaken.size() >= totalPre;
    }
}