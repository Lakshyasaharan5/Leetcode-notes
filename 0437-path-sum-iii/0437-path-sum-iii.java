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
    HashMap<Long, Integer> prefixSum = null;
    int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        prefixSum = new HashMap<>();
        prefixSum.put(0L,1);
        result = 0;
        dfs(root, targetSum, 0);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, long currSum) {
        if (root == null) return;
        currSum += root.val;
        if (prefixSum.containsKey(currSum - targetSum)) {
            result += prefixSum.get(currSum - targetSum);
        }
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        dfs(root.left, targetSum, currSum);
        dfs(root.right, targetSum, currSum);
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
    }
}