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
    /**
        left
        node
        right
    
     */
    int globalK = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null || res != -1) return;
        dfs(root.left, k);
        globalK += 1;
        if (globalK == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}