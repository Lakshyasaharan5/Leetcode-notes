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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        TreeNode l = null, r = null;
        if (p.val > q.val) {
            l = q;
            r = p;
        } else {
            l = p;
            r = q;
        }
        while (curr != null) {
            if (l.val <= curr.val && curr.val <= r.val) {
                return curr;
            }
            if (l.val < curr.val && r.val < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }
}