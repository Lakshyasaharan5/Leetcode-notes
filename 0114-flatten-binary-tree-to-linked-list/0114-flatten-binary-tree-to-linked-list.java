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
class Solution {
    public void flatten(TreeNode root) {
        TreeNode d = new TreeNode(-1);
        dfs(root, d);
        root = d.right;
    }

    private void dfs(TreeNode root, TreeNode d) {
        if (root == null) return;
        dfs(root.right, d);
        dfs(root.left, d);
        root.right = d.right;
        root.left = null;
        d.right = root;
    }
}