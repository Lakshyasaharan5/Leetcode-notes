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
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return result;
    }
    int dfs (TreeNode root) {
        if (root == null) return 0;
        if (!result) return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}