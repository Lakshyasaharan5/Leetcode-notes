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
    
                    4
                /        \
               2          6
            1     3         

           

                            90
                       *69
                    49     89
                      52

                    prev = 52
                    currDiff = 3
                    left = inf
                    right = 3                    
     */
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int leftDiff = minDiffInBST(root.left);
        int currDiff = Integer.MAX_VALUE;
        if (prev != null) {
            currDiff = root.val - prev.val;            
        }
        prev = root;
        int rightDiff = minDiffInBST(root.right);
        return Math.min(currDiff, Math.min(leftDiff, rightDiff));
        
    }
}