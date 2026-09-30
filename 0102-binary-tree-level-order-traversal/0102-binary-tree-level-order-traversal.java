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
        queue = [15,7]
        [3][9,20]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {            
            List<Integer> currLevel = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode front = queue.poll();
                currLevel.add(front.val);
                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);                
            }
            res.add(currLevel);
        }
        return res;
    }
}