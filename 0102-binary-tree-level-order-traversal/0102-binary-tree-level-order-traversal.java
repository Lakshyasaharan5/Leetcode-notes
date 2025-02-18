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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        int nodesEachLevel = 1;
        while(nodesEachLevel > 0){
            int currLevel = 0;
            List<Integer> curr = new ArrayList<>();
            while(nodesEachLevel > 0){
                TreeNode node = queue.remove();
                curr.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                    currLevel++;
                }
                if(node.right != null){
                    queue.add(node.right);
                    currLevel++;
                }
                nodesEachLevel--;
            }
            result.add(curr);
            nodesEachLevel = currLevel;
        }
        return result;
    }
}