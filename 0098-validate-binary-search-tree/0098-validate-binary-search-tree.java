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
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean left = isValidBST(root.left);
        boolean curr = true;
        if(prev!=null)
            curr = root.val > prev;
        prev = root.val;
        boolean right = isValidBST(root.right);
        return curr && right && left;
    }
}