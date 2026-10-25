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
        [[2,4],[1,3],[2,4],[1,3]]
        
        1 : [2,4]
        2 : [1,3]
        3 : [2,4]
        4 : [1,3]

        1-----2----------3
         \--------4-----/  

        og node : cp node
        1 : 1, 2:2, 4:4
        
        queue = [4,3]  2
        visited = [1,2,4]
        
        copy 
        1 : [2,4]
        2 : [1,3]

     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> valToCopy = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Node copy = new Node(node.val);
        valToCopy.put(node.val, copy);
        queue.offer(node);
        visited.add(node.val);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node currCopy = valToCopy.get(curr.val);
            for (Node nb : curr.neighbors) {
                if (!valToCopy.containsKey(nb.val)) {
                    valToCopy.put(nb.val, new Node(nb.val));
                }
                currCopy.neighbors.add(valToCopy.get(nb.val));
                if (!visited.contains(nb.val)) {
                    visited.add(nb.val);
                    queue.offer(nb);
                }
            }
        }
        return copy;
    }
}