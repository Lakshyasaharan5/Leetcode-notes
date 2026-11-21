class Solution {
    /**
        parent = [-1,0,0,1,1,1], s = "abaabc"
                   0 1 2 3 4 5

                    0a 
                  /   \
                1b      2a
             /  /  \
           3a  4b  5c
           a=0 a=1 a=1
           
           a : 0
           b : 1
           c : 5
                   
            [-1,0,0,0,1,1]
              0 1 2 3 4 5

            [6,3,1,1,1,1]
             0 1 2 3 4 5

        
     */
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tree.put(i, new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }
        int[] ancestor = new int[26];
        Arrays.fill(ancestor, -1);
        int[] modified = new int[n];
        dfs(tree, 0, s, parent, ancestor, modified);
        
        Map<Integer, List<Integer>> tree2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tree2.put(i, new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            tree2.get(modified[i]).add(i);
        }

        int[] subtreeSize = new int[n];        
        subtreeSize[0] = dfs2(tree2, 0, subtreeSize);
        return subtreeSize;
    }

    private int dfs2(Map<Integer, List<Integer>> tree2, int currValue, int[] subtreeSize) {
        int children = 0;
        for (int child : tree2.get(currValue)) {
            children += dfs2(tree2, child, subtreeSize);
        }
        subtreeSize[currValue] = children + 1;
        return subtreeSize[currValue];
    }

    private void dfs(Map<Integer, List<Integer>> tree, int currValue, String s, int[] parent, int[] ancestor, int[] modified) {
        int prevAncestor = ancestor[s.charAt(currValue) - 'a'];
        if (prevAncestor != -1) {
            modified[currValue] = prevAncestor;
        } else {
            modified[currValue] = parent[currValue];
        }
        ancestor[s.charAt(currValue) - 'a'] = currValue;
        for (int child : tree.get(currValue)) {
            dfs(tree, child, s, parent, ancestor, modified);
        }
        ancestor[s.charAt(currValue) - 'a'] = prevAncestor;
    }
}