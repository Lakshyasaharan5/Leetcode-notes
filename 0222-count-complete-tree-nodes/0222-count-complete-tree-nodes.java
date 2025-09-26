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
    public int countNodes(TreeNode root) {
        int count = 0;
        while (root != null ) {
            int left = height(root.left);
            int right = height(root.right);
            if (left == right) {
                count += Math.pow(2,left);
                root = root.right;
            } else {
                count += Math.pow(2, right);
                root = root.left;
            }
        }
        return count;
    }

    int height (TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }
}