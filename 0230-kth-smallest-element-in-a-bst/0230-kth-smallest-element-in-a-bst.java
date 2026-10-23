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
        Morris Traversal

                3 
             1      4 
               2

          curr = 1
            predecessor = go left and go extreme right
            if pred == null
                curr = curr.right
            else
                if pred.next == curr
                    pred.next = null
                    curr = curr.right
                else
                    pred.next = curr
                    curr = curr.left
            

          inorder -> 1 3 4 5 6
     */
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        TreeNode pred = null;
        while (curr != null) {
            pred = curr.left;
            while (pred != null && pred.right != null && pred.right != curr) {
                pred = pred.right;
            }
            if (pred == null) {
                k--;
                if (k == 0) return curr.val;
                curr = curr.right;
            } else {
                if (pred.right == curr) {
                    k--;
                    if (k == 0) return curr.val;
                    pred.right = null;                    
                    curr = curr.right;
                } else {
                    pred.right = curr;
                    curr = curr.left;
                }
            }
        }
        return 0;
    }
}