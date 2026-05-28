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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Map<Integer, TreeNode> nodes = new HashMap<>();
        TreeNode curr = null;
        for (int[] relation : descriptions) {
            int p = relation[0], c = relation[1], isLeft = relation[2];
            TreeNode parent = nodes.computeIfAbsent(p, k -> new TreeNode(k));
            TreeNode child = nodes.computeIfAbsent(c, k -> new TreeNode(k));
            parents.put(child, parent);
            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            curr = child;
        }
        // climb and find parent
        while (parents.containsKey(curr)) {
            curr = parents.get(curr);
        }
        return curr;
    }
}