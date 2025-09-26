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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int curr = root.val;
        int left = 0, right = 0;
        if (curr > low)
            left = rangeSumBST(root.left, low, high);        
        if (curr < high)
            right = rangeSumBST(root.right, low, high);
        if (low <= curr && curr <= high) {
            return curr + left + right;
        } else {
            return left + right;
        }
    }
}