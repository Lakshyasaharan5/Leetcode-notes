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
        while (root != null) {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            
            if (leftHeight == rightHeight) {
                // left subtree is perfect
                count += (1 << leftHeight); // root + all left nodes
                root = root.right;
            } else {
                // right subtree is perfect
                count += (1 << rightHeight); // root + all right nodes
                root = root.left;
            }
        }
        return count;
    }

    private int height(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }
}
