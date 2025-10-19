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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        totalSum = 0;
        dfs(root, 0);
        return totalSum;
    }

    private void dfs(TreeNode root, int currNumber) {
        if (root == null) return;
        currNumber = currNumber * 10 + root.val;
        
        dfs(root.left, currNumber);
        if (root.left == null && root.right == null) {
            totalSum += currNumber;
            return;
        }
        dfs(root.right, currNumber);
    }
}

