class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        /**
            [0,1,3,4] [0,2,3,4]
            0 --> 1
            |     |
            v     v
            2 --> 3 --> 4     
            |
            V
            5       
            
            que = [[0,1,3,4],[0,2,3,4]]
         */
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[][] graph, int start, List<Integer> curr, List<List<Integer>> res) {        
        curr.add(start);
        if (start == graph.length - 1) {
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        for (int nb : graph[start]) {
            dfs(graph, nb, curr, res);
        }
        curr.remove(curr.size() - 1);
    }
}