/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /**
            1-------2-------\
            \------4---------3
    
            1 : [2]
            2 : [3,1]
            3 : [4,2]
            4 : [1,3]
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, copy);
        dfs(node, map);
        return copy;
    }

    private void dfs(Node node, Map<Integer, Node> map) {
        Node currCopy = map.get(node.val);
        for (Node nb : node.neighbors) {
            if (!map.containsKey(nb.val)) {
                map.put(nb.val, new Node(nb.val));
                dfs(nb, map);
            }
            currCopy.neighbors.add(map.get(nb.val));
        }
    }
}