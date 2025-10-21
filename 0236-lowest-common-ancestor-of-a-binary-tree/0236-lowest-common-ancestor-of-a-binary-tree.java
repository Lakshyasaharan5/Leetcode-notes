/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    boolean found = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }
    
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        if (found) return true;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (((left && right) || ((left || right) && (root==p || root==q))) && !found) {
            found = true;
            lca = root;
        }
        return (left || right || root == p || root == q);
    }
}