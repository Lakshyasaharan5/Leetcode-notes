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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        TreeNode parent = null, curr = root;
        boolean isLeft = false;
        while (curr != null && curr.val != key) {
            parent = curr;
            if (key < curr.val) {
                curr = curr.left;
                isLeft = true;
            } else {
                curr = curr.right;
                isLeft = false;
            }
        }
        if (curr == null) return root;
        if (curr == root) {
            return deleteNode(root);
        }
        if (isLeft) {
            parent.left = deleteNode(curr);
        } else {
            parent.right = deleteNode(curr);
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode node) {
        TreeNode ch = null;
        boolean isLeft = false;
        if (node.left != null) {
            ch = node.left;
            isLeft = true;
        }
        else ch = node.right;
        if (ch == null) return null;
        TreeNode ls = ch.left, rs = ch.right;
        if (isLeft) {
            if (node.right == null) return ch;
            ch.right = node.right;
            TreeNode walk = node.right.left != null ? node.right.left : null;  
            if (walk == null) {
                ch.right.left = rs;
                return ch;
            }          
            while (walk.left != null) {
                walk = walk.left;
            }
            walk.left = rs;
        } else {
            if (node.left == null) return ch;
            ch.left = node.left;
            TreeNode walk = node.left.right != null ? node.left.right : null;  
            if (walk == null) {
                ch.left.right = ls;
                return ch;
            }          
            while (walk.right != null) {
                walk = walk.right;
            }
            walk.right = ls;
        }

        return ch;
    }
}