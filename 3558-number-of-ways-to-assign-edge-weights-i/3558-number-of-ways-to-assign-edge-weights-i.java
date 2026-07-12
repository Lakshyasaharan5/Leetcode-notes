class Solution {
    public int assignEdgeWeights(int[][] edges) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int n = edges.length + 1;
        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n + 1];
        int depth = dfs(tree, 1, visited) - 1;
        if (depth == 1) return 1;
        int res = 1;
        for (int i = 1; i <= depth - 1; i++) {
            res = (res * 2) % 1000000007;
        }
        return res;
        /**
            find number of edges to deepest path
            maths to find ways for total of odd

            [[1,2],[1,3],[3,4],[3,5]]
            1: [2,3]
            2: [1]
            3: [1,4,5]
            4: [3]
            5: [3]
            
            1:[2]
            2:[1]
            1-2

            1-2-3
               \
                4-5-6
            tree = adjacency list[]
            int depth = dfs(tree, start)

            maths example
            e e e o o o o o
            #e -> can be even or odd
            #o -> must be odd and >= 1

            depth = 3
            o o o
            o e e

            depth = 2
            o e

            depth = 1
            o            
         */
    }

    private int dfs(Map<Integer, List<Integer>> tree, int start, boolean[] visited) {  
        if (visited[start]) return 0;
        visited[start] = true;
        int curr = 0;
        for (int next : tree.get(start)) {
            curr = Math.max(curr, dfs(tree, next, visited));                
        }
        return curr + 1;
    }
}