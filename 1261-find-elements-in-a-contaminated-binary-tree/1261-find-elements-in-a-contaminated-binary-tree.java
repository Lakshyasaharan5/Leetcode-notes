/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

    /**
            0
              2
                6
     */
    Set<Integer> nodeValues;
    public FindElements(TreeNode root) {        
        nodeValues = new HashSet<>();
        recover(root, 0);
    }

    private void recover(TreeNode root, int val) {
        if (root == null) return;
        root.val = val;
        nodeValues.add(val);
        recover(root.left, 2 * val + 1);
        recover(root.right, 2 * val + 2);        
    }
    
    public boolean find(int target) {
        return nodeValues.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */