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
    
                    10
            -9             -20
                     -15         -7


                     node
                left     right

                left-node-right     28
                left-node     35
                node-right  13
                node    20
     */
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);        

        int currBestVal = Integer.MIN_VALUE;
        // node
        currBestVal = Math.max(currBestVal, root.val);
        maxSum = Math.max(maxSum, currBestVal);

        //node-left
        currBestVal = Math.max(currBestVal, root.val + left);
        maxSum = Math.max(maxSum, currBestVal);

        //node-right
        currBestVal = Math.max(currBestVal, root.val + right);
        maxSum = Math.max(maxSum, currBestVal);

        //left-node-right
        maxSum = Math.max(maxSum, left + root.val + right);

        return currBestVal;
    }
}